package com.zzr.apollo.tool.constants;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态值
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @date 2022/8/25 17:39
 */
@Getter
@AllArgsConstructor
public enum MasterStatusCode {
    /**
     * 预定
     */
    RESERVE("RS", "预定"),
    /**
     * 已付款
     */
    REPAY("RP", "已付款"),
    /**
     * 已取消
     */
    CANCELED("CXL", "已取消"),
    /**
     * 确认中
     */
    CONFIRMING("RCI", "确认中"),
    /**
     * 已确认
     */
    CONFIRMED("RC", "已确认"),
    /**
     * 执行中
     */
    DOING("DI", "执行中"),
    /**
     * 完成
     */
    COMPLETE("CO", "完成");

    final String code;
    final String message;
}
