package com.zzr.apollo.tool.constants;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 渠道状态值
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/9/1 10:05
 */
@Getter
@AllArgsConstructor
public enum DemoStatusCode {
    /**
     * 激活
     */
    ACTIVATE("A", "激活"),
    /**
     * 未激活
     */
    INACTIVE("I", "未激活");

    /**
     * 状态码
     */
    final String code;
    /**
     * 描述
     */
    final String message;

    /**
     * 状态码匹配
     *
     * @param code
     * @return
     */
    public static DemoStatusCode of(String code) {
        if (StrUtil.isBlank(code)) {
            return null;
        }
        for (DemoStatusCode value : DemoStatusCode.values()) {
            if (StrUtil.equals(value.getCode(), code)) {
                return value;
            }
        }
        return null;
    }
}
