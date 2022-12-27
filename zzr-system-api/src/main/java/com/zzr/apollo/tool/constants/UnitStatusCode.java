package com.zzr.apollo.tool.constants;

/**
 * 组织架构状态值
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/8/31 10:07
 */

public enum UnitStatusCode {
    /**
     * 起草
     */
    DRAFT("D", "起草"),
    /**
     * 已归档
     */
    ARCHIVED("A", "已归档"),
    /**
     * 已发布
     */
    PUBLISHED("P", "已发布");

    final String code;
    final String message;

    UnitStatusCode(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
