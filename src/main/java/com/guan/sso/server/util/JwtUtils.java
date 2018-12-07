package com.guan.sso.server.util;

import java.util.Base64;

/**
 * jwt utils
 */
public class JwtUtils {

    public static boolean isJwt(String token) {
        if(CommonUtil.isNotBlank(token)) {
            String[] params = token.split("\\.");
            if(3 == params.length) {
                String header = params[0];
                final Base64.Decoder decoder = Base64.getDecoder();
                header = new String(decoder.decode(header));
                return header.contains("alg") && header.contains("typ");
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
