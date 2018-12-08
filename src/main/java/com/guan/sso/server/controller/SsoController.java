package com.guan.sso.server.controller;

import com.guan.sso.server.entity.RedisDO;
import com.guan.sso.server.entity.SessionValue;
import com.guan.sso.server.grpc.stub.auth.AuthReply;
import com.guan.sso.server.grpc.stub.auth.AuthRequest;
import com.guan.sso.server.grpc.stub.auth.AuthServiceGrpc;
import com.guan.sso.server.services.RedisService;
import com.guan.sso.server.util.CommonUtil;
import com.guan.sso.server.util.SnowFlakeGenerator;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

import static com.guan.sso.server.constant.GlobalValue.X_LOGIN_MODEL;
import static com.guan.sso.server.constant.PageValue.*;
import static com.guan.sso.server.constant.RedisKey.UID_KEY;
import static com.guan.sso.server.constant.SessionKey.LOGIN_INFO;

@Controller
@RequestMapping("/")
public class SsoController {


    private final String code = "code";
    private final String msg = "msg";
    private final String loginParamsError = "用户名或密码不正确";

    private final String redirectException = "REDIRECT EXCEPTION : ";

    private Map<String, Object> resultMap = new HashMap<>();

    private Logger logger;

    @Autowired
    private HttpSession session;

    @Autowired
    private RedisService redisService;

//    @Autowired
//    private HttpServletResponse response;

    @Value("${author}")
    private String author;

    @RequestMapping("/login")
    public String login(@RequestParam(value = "u") String username,
                        @RequestParam(value = "p") String password,
                        Model model) {
        // 检查参数
        if (CommonUtil.isNotBlank(username, password)) {
            Long uid;
            try {
                uid = auth(username, password);
            } catch (Exception e) {
                Status status = Status.fromThrowable(e);
                model.addAttribute("exception", status.toString());
                return ERROR_PAGE;
            }
            // 验证
            if(0L != uid) {
                SnowFlakeGenerator snowFlakeGenerator = new SnowFlakeGenerator.Factory().create(5L, 5L);
                Long sk = snowFlakeGenerator.nextId();
                RedisDO redisDO = new RedisDO();
                redisDO.setUid(uid);


                redisService.set(UID_KEY + uid, redisDO, 60 * 60L);

                //CookiesUtil.writeCookie(response, redisKeyName, sk.toString());
//                try {
//                    //response.sendRedirect(s_url);
//                } catch (IOException e) {
//                    logger.error(redirectException + e);
//                }
            } else {
                model.addAttribute(code, false);
                model.addAttribute(msg, loginParamsError);
            }
        } else {
            model.addAttribute(code, false);
            model.addAttribute(msg, loginParamsError);
        }
        SessionValue sessionValue = (SessionValue) session.getAttribute(LOGIN_INFO);
        if (CommonUtil.isNotNull(sessionValue)) {
            if (X_LOGIN_MODEL == sessionValue.getXlogin()) {
                return X_LOGIN_PAGE;
            } else {
                return LOGIN_PAGE;
            }
        } else {
            return DENY_PAGE;
        }
    }

    private Long auth(String username, String password) {
        AuthRequest request = AuthRequest.newBuilder().setAcc(username).setPwd(password).build();
        System.out.println(" request ");
        Channel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 50051).usePlaintext().build();
        AuthServiceGrpc.AuthServiceBlockingStub authServiceBlockingStub = AuthServiceGrpc.newBlockingStub(channel);
        AuthReply reply = authServiceBlockingStub.auth(request);
        System.out.println(" reply ");
        return reply.getId();
    }


    @RequestMapping("/author")
    public String author(Model model) {
        model.addAttribute("author", author);
        return "author";
    }

}
