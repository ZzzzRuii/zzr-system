package com.zzr.apollo.tool.constants;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 退款状态值
 *
 * @author ZhouZhiRui , zzr@foxhis.com
 * @since 2022/9/9 13:23
 */
@Getter
@AllArgsConstructor
public enum RefundStatusCode {
    /**
     * R 待审核
     */
    AUDIT("R", "待审核"),
    /**
     * A 已审核
     */
    AUDITED("A", "已审核"),
    /**
     * RJ 已拒绝
     */
    REFUSED("RJ", "已拒绝"),
    /**
     * X 已取消
     */
    CANCELED("X", "已取消"),
    /**
     * RE 已退款中
     */
    REFUNDING("RE", "已退款中"),
    /**
     * RC 已确认
     */
    CONFIRMING("RC", "已确认"),
    /**
     * DI 执行中
     */
    DOING("DI", "执行中"),
    /**
     * CO 已完成
     */
    COMPLETE("CO", "已完成");

    /**
     * 状态码
     */
    final String code;
    /**
     * 描述
     */
    final String description;

    /**
     * 状态码匹配
     *
     * @param code
     * @return
     */
    public static RefundStatusCode of(String code) {
        if (StrUtil.isBlank(code)) {
            return null;
        }
        for (RefundStatusCode value : RefundStatusCode.values()) {
            if (StrUtil.equals(value.getCode(), code)) {
                return value;
            }
        }
        return null;
    }
}
