package com.guan.sso.server.controller;

import com.guan.sso.server.services.RedisService;
import com.guan.sso.server.util.CookiesUtil;
import com.guan.sso.server.util.SnowFlakeGenerator;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class Controller {

    private static final String C_KEY_NAME = "sk";

    private Map<String, Object> resultMap = new HashMap<>();

    @Autowired
    private RedisService redisService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Value("${author}")
    private String author;

    @RequestMapping("/")
    public Map certifySecretKey() {
        String sk = CookiesUtil.readCookie(request, C_KEY_NAME);
        Integer code;
        String msg;
        if(null != sk && redisService.has(C_KEY_NAME + ":" + sk)) {
            code = HttpStatus.SC_OK;
            msg = "认证完毕";
        } else {
            code = HttpStatus.SC_UNAUTHORIZED;
            msg = "非法请求";
        }
        resultMap.put("code", code);
        resultMap.put("data", "");
        resultMap.put("msg", msg);
        return resultMap;
    }

    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String passwd) {
        if(username.equals("guanhao") && passwd.equals("lvtong")) {
            SnowFlakeGenerator snowFlakeGenerator = new SnowFlakeGenerator.Factory().create(5L, 5L);
            Long sk = snowFlakeGenerator.nextId();
            redisService.set(C_KEY_NAME + ":" + sk, sk, 60 * 60L);
            CookiesUtil.writeCookie(response, C_KEY_NAME, sk.toString());
            return "login ok";
        } else {
            return "login fail";
        }
    }

    @RequestMapping("/logout")
    public String logout() {
        String sk = CookiesUtil.readCookie(request, C_KEY_NAME);
        Integer code;
        String msg;
        if(null != sk && redisService.has(sk)) {
            redisService.delete(C_KEY_NAME + ":" + sk);
            code = HttpStatus.SC_OK;
            msg = "退出完毕";
        } else {
            code = HttpStatus.SC_UNAUTHORIZED;
            msg = "非法请求";
        }
        resultMap.put("code", code);
        resultMap.put("data", "");
        resultMap.put("msg", msg);
        return "logout ok";
    }

    @RequestMapping("/author")
    public String author() {
        return author;
    }

}
