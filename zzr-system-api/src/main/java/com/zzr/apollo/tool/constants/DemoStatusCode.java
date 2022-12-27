package com.zzr.apollo.tool.constants;

/**
 * 渠道状态值
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/9/1 10:05
 */

public enum DemoStatusCode {
    /**
     * 激活
     */
    ACTIVATE("A", "激活"),
    /**
     * 未激活
     */
    INACTIVE("D", "未激活");

    final String code;
    final String message;

    DemoStatusCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
