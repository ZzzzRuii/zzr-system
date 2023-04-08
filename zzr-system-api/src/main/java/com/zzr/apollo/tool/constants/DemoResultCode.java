package com.zzr.apollo.tool.constants;


import com.zzr.base.api.IResultCode;

/**
 * 请求结果常量
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/9/1 16:24
 */
public enum DemoResultCode implements IResultCode {
    /**
     * 数据已存在
     */
    DATA_ALREADY_EXIST(10003, "数据已存在"),
    /**
     * 存在父项，不能删除
     */
    PARENT_EXISTS(10003, "存在父项，不能删除"),
    /**
     * 库存不足
     */
    UNDER_STOCK(10003, "库存不足"),
    /**
     * 来源有误
     */
    SRC_ERROR(10017, "来源有误"),
    /**
     * 组织不存在
     */
    UNIT_NOT_EXISTS(10004, "组织不存在"),
    /**
     * 产品不存在
     */
    PRODUCT_NOT_EXISTS(10005, "产品不存在"),
    /**
     * 订单不能重复取消
     */
    ORDER_CANNOT_BE_CANCELLED_REPEATEDLY(10006, "订单不能重复取消"),
    /**
     * 订单状态不正确，无法退款
     */
    WRONG_ORDER_STATUS(10007, "订单状态不正确，无法退款"),
    ;

    final int code;
    final String message;

    DemoResultCode(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }
}
