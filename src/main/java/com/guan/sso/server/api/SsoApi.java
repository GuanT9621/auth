package com.guan.sso.server.api;

import com.guan.sso.server.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * api api class
 */
@RequestMapping("/")
public class SsoApi {

    private static final String REDIS_NAME_SPACE = "SSO_TOKEN:";

    @Autowired
    private RedisService redisService;

    /**
     * Verify the token is valid
     * @return
     */
    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public String verifyToken(@PathVariable String token) {
        return String.valueOf(redisService.has(REDIS_NAME_SPACE + token));
    }

    /**
     * The user information corresponding to the query token
     * @return Map
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getInfoByToken(@PathVariable String token) {
        return String.valueOf(redisService.get(REDIS_NAME_SPACE + token));
    }

    /**
     * Log in and generate the token
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password) {
        // TODO 验证、生成、存储、记录、返回
        return null;
    }

    /**
     * Exit and delete the token
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout() {
        // TODO 删除、记录
        return null;
    }

}
