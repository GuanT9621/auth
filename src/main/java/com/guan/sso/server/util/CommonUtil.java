package com.guan.sso.server.util;


import org.apache.commons.lang.StringUtils;

public class CommonUtil {

    /**
     * Determines if a Object is Null or not.
     *
     * @param objects
     * @return true if its null, false otherwise.
     */
    public static boolean isNotNull(Object... objects) {
        for (Object object : objects) {
            if (null == object) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines if a String is blank or not. A String is blank if its empty or
     * if it only contains spaces.
     *
     * @param strings the string to check
     * @return true if its blank, false otherwise.
     */
    public static boolean isNotBlank(final String... strings) {
        for (String string : strings) {
            if (StringUtils.isBlank(string)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines whether the String is null or of length 0.
     *
     * @param strings the string to check
     * @return true if its null or length of 0, false otherwise.
     */
    public static boolean isNotEmpty(final String... strings) {
        for (String string : strings) {
            if (StringUtils.isEmpty(string)) {
                return false;
            }
        }
        return true;
    }
}
