package com.guan.sso.server.controller;

import com.guan.sso.server.entity.RedisDO;
import com.guan.sso.server.entity.SessionValue;
import com.guan.sso.server.grpc.stub.auth.AuthReply;
import com.guan.sso.server.grpc.stub.auth.AuthRequest;
import com.guan.sso.server.grpc.stub.auth.AuthServiceGrpc;
import com.guan.sso.server.services.RedisService;
import com.guan.sso.server.util.CommonUtil;
import com.guan.sso.server.util.CookiesUtil;
import com.guan.sso.server.util.TokenUtil;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.guan.sso.server.constant.GlobalValue.TOKEN_ALIVE_TIME;
import static com.guan.sso.server.constant.PageValue.*;
import static com.guan.sso.server.constant.SessionKey.LOGIN_INFO;
import static com.guan.sso.server.util.CookiesUtil.SSO_COOKIE_NAME;

@Controller
@RequestMapping("/")
public class SsoController {

    // 应该在数据库里查询appid的注册信息 这里仅作为实验
    private static final Map<Long, String> APP_ID_PREIFX_URLS = new HashMap<>();

    private static final String MK_CODE = "code";
    private static final String MK_MSG = "msg";
    private static final String MK_REASON = "logException";
    private static final String MK_JUMP = "jump";

    private static final String LOG_EXCEPTION = "EXCEPTION :";

    private static final String MV_ILLEGAL_PARAM = "Illegal parameter";
    private static final String MV_ILLEGAL_APP_ID = "Illegal appId";
    private static final String MV_ILLEGAL_URL = "Illegal s_url";
    private static final String MV_PARAMS_RROR = "用户名或密码不正确";
    private static final String MV_LATER_TRY = "服务繁忙，请稍后再试";

    private Logger logger = LoggerFactory.getLogger(SsoController.class);

    static {
        APP_ID_PREIFX_URLS.put(10001L, "http://picture.trycatch.com");
        APP_ID_PREIFX_URLS.put(10002L, "http://linux.trycatch.com");
        APP_ID_PREIFX_URLS.put(10003L, "http://www.trycatch.com");
        APP_ID_PREIFX_URLS.put(10004L, "http://space.trycatch.com");
    }

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

    @Value("${domain}")
    private String domain;

    /**
     * 登录页面
     *
     * @param appId 应用id
     * @param redirectUrl 跳转的url
     * @param model ui
     * @return String
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "appid") Long appId,
                        @RequestParam(value = "s_url") String redirectUrl,
                        Model model) {
        if (!rightfulParams(appId, redirectUrl, model)) {
            return PAGE_DENY;
        }

        if (isLogin()) {
            try {
                response.sendRedirect(redirectUrl);
            } catch (IOException ioe) {
                logger.error(LOG_EXCEPTION, ioe);
            }
            model.addAttribute(MK_JUMP, redirectUrl);
            return PAGE_JUMP;
        }

        loadSessionValue(appId, redirectUrl);
        return PAGE_LOGIN;

    }

    /**
     * 参数合法检查
     * @param appId app id
     * @param redirectUrl 跳转url
     * @param model 页面模型
     * @return boolean
     */
    private boolean rightfulParams(Long appId, String redirectUrl, Model model) {
        // 检验参数
        if (!CommonUtil.isNotNull(appId, redirectUrl)) {
            model.addAttribute(MK_REASON, MV_ILLEGAL_PARAM);
            return false;
        }
        // 检验参数appId
        if (!APP_ID_PREIFX_URLS.containsKey(appId)) {
            model.addAttribute(MK_REASON, MV_ILLEGAL_APP_ID);
            return false;
        }

        // 检验参数redirectUrl
        if (redirectUrl.startsWith(APP_ID_PREIFX_URLS.get(appId))) {
            return true;
        } else {
            model.addAttribute(MK_REASON, MV_ILLEGAL_URL);
            return false;
        }

    }

    /**
     * load session-value to session
     * @param appId app id
     * @param redirectUrl 跳转rul
     */
    private void loadSessionValue(Long appId, String redirectUrl) {
        SessionValue sessionValue = new SessionValue();
        sessionValue.setAppId(appId);
        sessionValue.setRedirectUrl(redirectUrl);
        session.setAttribute(LOGIN_INFO, sessionValue);
    }

    /**
     * 判断是否已经登录
     * @return boolean
     */
    private boolean isLogin() {
        String cookieSk = CookiesUtil.readCookie(request, SSO_COOKIE_NAME);
        return null != cookieSk && redisService.has(cookieSk, TOKEN_ALIVE_TIME);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "u") String username,
                        @RequestParam(value = "p") String password,
                        @RequestParam(value = "k") Integer keep,
                        Model model) {
        SessionValue sessionValue = (SessionValue) session.getAttribute(LOGIN_INFO);

        // 前置条件，调用本接口必须经过调用页面
        if (!CommonUtil.isNotNull(sessionValue)) {
            model.addAttribute(MK_REASON, MV_ILLEGAL_PARAM);
            return PAGE_DENY;
        }

        // 检查参数
        if (!CommonUtil.isNotBlank(username, password)) {
            model.addAttribute(MK_CODE, false);
            model.addAttribute(MK_MSG, MV_PARAMS_RROR);
            return PAGE_LOGIN;
        }

        // 已经登录
        if (isLogin()) {
            String redirectUrl = sessionValue.getRedirectUrl();
            try {
                response.sendRedirect(redirectUrl);
            } catch (IOException ioe) {
                logger.error(LOG_EXCEPTION, ioe);
            }
            model.addAttribute(MK_JUMP, redirectUrl);
            return PAGE_JUMP;
        }

        // 未登录做验证
        Long uid;
        try {
            uid = auth(username, password);
        } catch (Exception e) {
            logger.error(LOG_EXCEPTION,  e);
            model.addAttribute(MK_CODE, false);
            model.addAttribute(MK_CODE, MV_LATER_TRY);
            return PAGE_LOGIN;
        }

        if(0L != uid) {
            RedisDO redisDO = new RedisDO();
            redisDO.setUid(uid);
            String token = TokenUtil.makeToken();
            redisService.set(token, redisDO, TOKEN_ALIVE_TIME);
            // 一个月不过期
            Integer expiry;
            if (0 == keep) {
                expiry =  -1;
            } else {
                expiry = 60 * 60 * 24 * keep;
            }
            CookiesUtil.writeCookie(response, domain, SSO_COOKIE_NAME, token, expiry);
            String redirectUrl = sessionValue.getRedirectUrl();
            String html = "<script type='text/javascript'>location.href='" + redirectUrl + "';</script>";
            try {
                response.getWriter().print(html);
            } catch (IOException e) {
                logger.error(LOG_EXCEPTION, e);
            }
            model.addAttribute(MK_JUMP, redirectUrl);
            return PAGE_JUMP;
        } else {
            model.addAttribute(MK_CODE, false);
            model.addAttribute(MK_MSG, MV_PARAMS_RROR);
            return PAGE_LOGIN;
        }

    }

    /**
     * 登录认证
     * @param username 用户名
     * @param password 密码
     * @return Long
     */
    private Long auth(String username, String password) {
        AuthRequest request = AuthRequest.newBuilder().setAcc(username).setPwd(password).build();
        Channel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        AuthServiceGrpc.AuthServiceBlockingStub authServiceBlockingStub = AuthServiceGrpc.newBlockingStub(channel);
        AuthReply reply = authServiceBlockingStub.auth(request);
        return reply.getId();
    }

}
