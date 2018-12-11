package com.guan.sso.server.page;

import com.guan.sso.server.entity.SessionValue;
import com.guan.sso.server.services.RedisService;
import com.guan.sso.server.util.CommonUtil;
import com.guan.sso.server.util.CookiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.guan.sso.server.constant.GlobalValue.TOKEN_ALIVE_TIME;
import static com.guan.sso.server.constant.GlobalValue.X_LOGIN_MODEL;
import static com.guan.sso.server.constant.PageValue.*;
import static com.guan.sso.server.constant.SessionKey.LOGIN_INFO;
import static com.guan.sso.server.util.CookiesUtil.SSO_COOKIE_NAME;

@Controller
@RequestMapping("/auth")
public class PageController {

    // 应该在数据库里查询appid的注册信息 这里仅作为实验
    private static final Map<Long, String> APP_ID_PREIFX_URLS = new HashMap<>();

    private final String reason = "reason";

    private final String illegalParam = "Illegal parameter";
    private final String illegalAppId = "Illegal appId";
    private final String illegalUrl = "Illegal s_url";

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private RedisService redisService;

    static {
        APP_ID_PREIFX_URLS.put(10001L, "http://picture.trycatch.com");
        APP_ID_PREIFX_URLS.put(10002L, "http://linux.trycatch.com");
        APP_ID_PREIFX_URLS.put(10003L, "http://www.trycatch.com");
        APP_ID_PREIFX_URLS.put(10004L, "http://space.trycatch.com");
    }

    /**
     * 登录页面
     *
     * @param appId 应用id
     * @param redirectUrl 跳转的url
     * @param xlogin xlogin模式
     * @param model ui
     * @return
     */
    @RequestMapping(value = "login")
    public String login(@RequestParam(value = "appid") Long appId,
                        @RequestParam(value = "s_url") String redirectUrl,
                        @RequestParam(value = "x_login") Integer xlogin,
                        Model model) {
        if (checkParams(appId, redirectUrl, xlogin, model)) {
            // 检验是否已经登录
            if (isLogin()) {
                try {
                    response.sendRedirect(redirectUrl);
                    return JUMP_PAGE;
                } catch (IOException ioe) {
                    return ERROR_PAGE;
                }
            } else {
                // 未登录则进入登录页面
                SessionValue sessionValue = new SessionValue();
                sessionValue.setAppId(appId);
                sessionValue.setRedirectUrl(redirectUrl);
                sessionValue.setXlogin(xlogin);
                session.setAttribute(LOGIN_INFO, sessionValue);
                if (X_LOGIN_MODEL == xlogin) {
                    return X_LOGIN_PAGE;
                } else {
                    return LOGIN_PAGE;
                }
            }
        }
        return DENY_PAGE;
    }

    /**
     * 参数检查
     * @param appId
     * @param redirectUrl
     * @param xlogin
     * @param model
     * @return
     */
    private boolean checkParams( Long appId, String redirectUrl, Integer xlogin, Model model) {
        // 检验参数不空
        if (CommonUtil.isNotNull(appId, redirectUrl, xlogin)) {
            // 检验参数合法
            if (APP_ID_PREIFX_URLS.containsKey(appId)) {
                if (redirectUrl.startsWith(APP_ID_PREIFX_URLS.get(appId))) {
                    return true;
                } else {
                    model.addAttribute(reason, illegalUrl);
                }
            } else {
                model.addAttribute(reason, illegalAppId);
            }
        } else {
            model.addAttribute(reason, illegalParam);
        }
        return false;
    }

    /**
     * 判断是否已经登录
     * @return
     */
    private boolean isLogin() {
        String cookieSk = CookiesUtil.readCookie(request, SSO_COOKIE_NAME);
        return null != cookieSk && redisService.has(cookieSk, TOKEN_ALIVE_TIME);
    }

}
