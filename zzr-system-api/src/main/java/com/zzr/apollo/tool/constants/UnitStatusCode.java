package com.zzr.apollo.tool.constants;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 组织架构状态值
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/8/31 10:07
 */
@Getter
@AllArgsConstructor
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
    public static UnitStatusCode of(String code) {
        if (StrUtil.isBlank(code)) {
            return null;
        }
        for (UnitStatusCode value : UnitStatusCode.values()) {
            if (StrUtil.equals(value.getCode(), code)) {
                return value;
            }
        }
        return null;
    }
}
