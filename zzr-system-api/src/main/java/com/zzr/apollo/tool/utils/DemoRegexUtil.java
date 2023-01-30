package com.zzr.apollo.tool.utils;


import com.zzr.base.utils.RegexUtil;

/**
 * 订单正则工具
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 16:09
 */
public class DemoRegexUtil extends RegexUtil {
    public static final String TENANT_ID = "^[a-zA-Z0-9_]{2,12}$";
    public static final String UNIT_TYPE = "^[A-Z][a-zA-Z0-9_]{1,14}$";
    public static final String CODE36 = "^[A-Z0-9_]{2,36}$";
    public static final String CODE15 = "^[A-Z0-9_]{2,15}$";
    public static final String NAME100 = "^[a-zA-Z\\u4E00-\\u9FA5][a-zA-Z0-9_\\u4E00-\\u9FA5]{1,99}$";
    public static final String CATALOG15 = "^[a-zA-Z\\u4E00-\\u9FA5][a-zA-Z0-9_\\u4E00-\\u9FA5]{1,15}$";
    public static final String FLAG50 = "^[a-zA-Z\\u4E00-\\u9FA5][a-zA-Z0-9_\\u4E00-\\u9FA5]{1,50}$";
    public static final String CODE30 = "^[A-Z0-9_]{2,36}$";
}
