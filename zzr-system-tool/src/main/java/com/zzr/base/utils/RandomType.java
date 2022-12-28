package com.zzr.base.utils;

/**
 * RandomType
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/28 10:37
 */
public enum RandomType {
    INT("0123456789"),
    STRING("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"),
    ALL("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");

    private final String factor;
    private static final String INT_STR = "0123456789";
    private static final String STR_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String ALL_STR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String getFactor() {
        return this.factor;
    }

    RandomType(final String factor) {
        this.factor = factor;
    }
}
