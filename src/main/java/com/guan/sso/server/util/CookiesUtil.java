package com.guan.sso.server.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtil {

    public static final String SSO_COOKIE_NAME = "SID";

    /**
     * 读取cookie
     *
     * @param request request
     * @param cookieName 键
     * @return String
     */
    public static String readCookie(HttpServletRequest request, String cookieName){
        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(cookieName)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 设置cookie
     *
     * @param response response
     * @param domain domain
     * @param cookieName 键
     * @param value 值
     * @param expiry 时间 -1 意味着和会话一致
     */
    public static void writeCookie(HttpServletResponse response, String domain, String cookieName, String value, int expiry){
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setDomain(domain);
        cookie.setPath("/");
        cookie.setMaxAge(expiry);
        response.addCookie(cookie);
    }

}
