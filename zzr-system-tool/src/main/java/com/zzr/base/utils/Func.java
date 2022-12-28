package com.zzr.base.utils;

import org.springframework.lang.Nullable;

import java.util.Objects;

/**
 * Func
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/28 10:29
 */
public class Func {
    public static boolean hasEmpty(Object... os) {
        Object[] var1 = os;
        int var2 = os.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            Object o = var1[var3];
            if (isEmpty(o)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isEmpty(@Nullable Object obj) {
        return ObjectUtil.isEmpty(obj);
    }

    public static boolean isEmpty(@Nullable Object[] array) {
        return ObjectUtil.isEmpty(array);
    }

    public static boolean equals(Object obj1, Object obj2) {
        return Objects.equals(obj1, obj2);
    }

    public static String toStr(Object str) {
        return toStr(str, "");
    }

    public static String toStr(Object str, String defaultValue) {
        return null != str && !str.equals("null") ? String.valueOf(str) : defaultValue;
    }
}
