package com.zzr.base.utils;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

/**
 * ObjectUtil
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/28 10:32
 */
public class ObjectUtil extends ObjectUtils {
    public ObjectUtil() {
    }

    public static boolean isNotEmpty(@Nullable Object obj) {
        return !isEmpty(obj);
    }
}
