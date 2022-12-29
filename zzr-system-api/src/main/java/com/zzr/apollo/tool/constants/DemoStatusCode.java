package com.zzr.apollo.tool.constants;

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

    final String code;
    final String message;
}
