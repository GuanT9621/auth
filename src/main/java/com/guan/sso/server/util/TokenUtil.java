package com.guan.sso.server.util;

public class TokenUtil {

    public static final String TOKEN_KEY = "gst.";

    public static final String makeToken() {
        SnowFlakeGenerator snowFlakeGenerator = new SnowFlakeGenerator.Factory().create(5L, 5L);
        Long sk = snowFlakeGenerator.nextId();
        return TOKEN_KEY + sk;
    }

}
