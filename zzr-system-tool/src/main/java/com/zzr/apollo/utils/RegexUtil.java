package com.zzr.apollo.utils;

/**
 * RegexUtil
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 16:09
 */
public class RegexUtil {
    public static final String ENGLISH_NAME = "(^[a-zA-Z]{1}[a-zA-Z\\s]{0,20}[a-zA-Z]{1}$)";
    public static final String CHINESE_NAME = "^(?:[\\u4e00-\\u9fa5·]{2,16})$";
    public static final String USER_NAME = "^[a-zA-Z\\u4E00-\\u9FA5][a-zA-Z0-9_\\u4E00-\\u9FA5]{1,11}$";
    public static final String USER_PASSWORD = "^.{6,32}$";
    public static final String EMAIL = "^\\w+([-+.]*\\w+)*@([\\da-z](-[\\da-z])?)+(\\.{1,2}[a-z]+)+$";
    public static final String PHONE = "^1[3456789]\\d{9}$";
    public static final String EMAIL_OR_PHONE = "^\\w+([-+.]*\\w+)*@([\\da-z](-[\\da-z])?)+(\\.{1,2}[a-z]+)+$|^1[3456789]\\d{9}$";
    public static final String URL = "^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})(:[\\d]+)?([\\/\\w\\.-]*)*\\/?$";
    public static final String ID_CARD = "^\\d{15}$|^\\d{17}([0-9]|X)$";
    public static final String DOMAIN = "^[0-9a-zA-Z]+[0-9a-zA-Z\\.-]*\\.[a-zA-Z]{2,4}$";
    public static final String CODE10 = "^[A-Z][A-Z0-9_]{2,10}$";
    public static final String CODE15 = "^[A-Z][A-Z0-9_]{2,15}$";
    public static final String CODE20 = "^[A-Z][A-Z0-9_]{2,20}$";
    public static final String CODE30 = "^[A-Z][A-Z0-9_]{2,30}$";
    public static final String CODE40 = "^[A-Z][A-Z0-9_]{2,40}$";
    public static final String CODE50 = "^[A-Z][A-Z0-9_]{2,50}$";
}
