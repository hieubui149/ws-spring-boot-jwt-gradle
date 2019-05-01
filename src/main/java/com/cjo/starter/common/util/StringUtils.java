package com.cjo.starter.common.util;

import java.util.Arrays;
import java.util.List;

/**
 * @author hieubui
 * @date 2019-05-01
 */
public class StringUtils {

    private static final String STRING_SEPARATOR = ",";

    public static String join(List<String> items) {
        return String.join(STRING_SEPARATOR, items);
    }

    public static List<String> split(String joinedString) {
        return Arrays.asList(joinedString.split(STRING_SEPARATOR));
    }

}
