package com.guan.sso.server.controller;

import com.guan.sso.server.entity.RedisDO;
import com.guan.sso.server.entity.SessionValue;
import com.guan.sso.server.grpc.stub.auth.AuthReply;
import com.guan.sso.server.grpc.stub.auth.AuthRequest;
import com.guan.sso.server.grpc.stub.auth.AuthServiceGrpc;
import com.guan.sso.server.services.RedisService;
import com.guan.sso.server.util.CommonUtil;
import com.guan.sso.server.util.CookiesUtil;
import com.guan.sso.server.util.SnowFlakeGenerator;
import com.guan.sso.server.util.TokenUtil;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.guan.sso.server.constant.GlobalValue.TOKEN_ALIVE_TIME;
import static com.guan.sso.server.constant.GlobalValue.X_LOGIN_MODEL;
import static com.guan.sso.server.constant.PageValue.*;
import static com.guan.sso.server.constant.SessionKey.LOGIN_INFO;
import static com.guan.sso.server.util.CookiesUtil.SSO_COOKIE_NAME;

@Controller
@RequestMapping("/server")
public class SsoController {

    private final String code = "code";
    private final String msg = "msg";
    private final String loginParamsError = "用户名或密码不正确";

    private final String reason = "exception";

    private final String exception = "EXCEPTION :";

    private Logger logger = LoggerFactory.getLogger(SsoController.class);

    @Autowired
    private HttpSession session;

    @Autowired
    private RedisService redisService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Value("${rpc.ums.port}")
    private int port;

    @Value("${rpc.ums.address}")
    private String address;

    @Value("${author}")
    private String author;

    @Value("${domain}")
    private String domain;

    @RequestMapping("/login")
    public String login(@RequestParam(value = "u") String username,
                        @RequestParam(value = "p") String password,
                        Model model) {
        SessionValue sessionValue = (SessionValue) session.getAttribute(LOGIN_INFO);
        // 前置条件，调用本接口必须经过调用页面
        if (CommonUtil.isNotNull(sessionValue)) {
            // 检查参数
            if (CommonUtil.isNotBlank(username, password)) {
                try {
                    if (isLogin()) {
                        return JUMP_PAGE;
                    }
                } catch (IOException ioe) {
                    logger.error(exception, ioe);
                    return ERROR_PAGE;
                }
                Long uid;
                try {
                    uid = auth(username, password);
                } catch (Exception e) {
                    logger.error(exception,  e);
                    Status status = Status.fromThrowable(e);
                    model.addAttribute(reason, status.toString());
                    return ERROR_PAGE;
                }
                // 验证
                if(0L != uid) {
                    RedisDO redisDO = new RedisDO();
                    redisDO.setUid(uid);
                    String token = TokenUtil.makeToken();
                    redisService.set(token, redisDO, TOKEN_ALIVE_TIME);
                    CookiesUtil.writeCookie(response, domain, SSO_COOKIE_NAME, token);
                    try {
                        String redirectUrl = sessionValue.getRedirectUrl();
                        String html = "<script type='text/javascript'>location.href='" + redirectUrl + "';</script>";
                        response.getWriter().print(html);
                    } catch (IOException e) {
                        logger.error(exception, e);
                    }
                }
            }
            // 认证成功直接跳转，认证失败才会到达这里
            model.addAttribute(code, false);
            model.addAttribute(msg, loginParamsError);
            if (X_LOGIN_MODEL == sessionValue.getXlogin()) {
                return X_LOGIN_PAGE;
            } else {
                return LOGIN_PAGE;
            }
        } else {
            return DENY_PAGE;
        }
    }
    /**
     * 判断是否已经登录
     * @return
     */
    private boolean isLogin() throws IOException {
        String cookieSk = CookiesUtil.readCookie(request, SSO_COOKIE_NAME);
        if (null != cookieSk && redisService.has(cookieSk, TOKEN_ALIVE_TIME)) {
            SessionValue sessionValue = (SessionValue) session.getAttribute(LOGIN_INFO);
            String redirectUrl = sessionValue.getRedirectUrl();
            response.sendRedirect(redirectUrl);
            return true;
        }
        return false;
    }

    /**
     * 登录认证
     * @param username
     * @param password
     * @return
     */
    private Long auth(String username, String password) {
        AuthRequest request = AuthRequest.newBuilder().setAcc(username).setPwd(password).build();
        Channel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        AuthServiceGrpc.AuthServiceBlockingStub authServiceBlockingStub = AuthServiceGrpc.newBlockingStub(channel);
        AuthReply reply = authServiceBlockingStub.auth(request);
        return reply.getId();
    }

    /**
     * 作者
     * @param model
     * @return
     */
    @RequestMapping("/author")
    public String author(Model model) {
        model.addAttribute("author", author);
        return "author";
    }

}
