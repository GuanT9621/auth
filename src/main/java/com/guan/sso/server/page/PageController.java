package com.guan.sso.server.page;

import com.guan.sso.server.entity.SessionValue;
import com.guan.sso.server.grpc.stub.AuthRequest;
import com.guan.sso.server.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static com.guan.sso.server.constant.GlobalValue.X_LOGIN_MODEL;
import static com.guan.sso.server.constant.PageValue.DENY_PAGE;
import static com.guan.sso.server.constant.PageValue.LOGIN_PAGE;
import static com.guan.sso.server.constant.PageValue.X_LOGIN_PAGE;
import static com.guan.sso.server.constant.SessionKey.LOGIN_INFO;

@Controller
@RequestMapping("/auth")
public class PageController {

    // 应该在数据库里查询appid的注册信息 这里仅作为实验
    private static final Map<Long, String> APP_ID_PREIFX_URL = new HashMap<>();

    private final String reason = "reason";

    private final String illegalParam = "Illegal parameter";
    private final String illegalAppId = "Illegal appId";
    private final String illegalUrl = "Illegal s_url";

    @Autowired
    private HttpSession session;

    static {
        APP_ID_PREIFX_URL.put(1234L, "http://www.guan.com");
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
        if (CommonUtil.isNotNull(appId, redirectUrl, xlogin)) {
            if (APP_ID_PREIFX_URL.containsKey(appId)) {
                if (redirectUrl.startsWith(APP_ID_PREIFX_URL.get(appId))) {
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
                } else {
                    model.addAttribute(reason, illegalUrl);
                }
            } else {
                model.addAttribute(reason, illegalAppId);
            }
        } else {
            model.addAttribute(reason, illegalParam);
        }
        return DENY_PAGE;
    }

}
