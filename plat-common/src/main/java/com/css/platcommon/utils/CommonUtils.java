package com.css.platcommon.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : lin
 * @date : 21:17 2021/10/26
 */
public class CommonUtils {
    /**
     *  驼峰转下划线
     * @param str
     * @return
     */
    public static String humpToLine(String str) {
        Pattern humpPattern = Pattern.compile("[A-Z]");
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
