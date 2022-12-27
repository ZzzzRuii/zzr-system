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
    DATA_ALREADY_EXIST(403, "数据已存在"),
    /**
     * 存在父项，不能删除
     */
    PARENT_EXISTS(403, "存在父项，不能删除"),
    /**
     * 库存不足
     */
    UNDER_STOCK(403, "库存不足"),
    /**
     * 来源有误
     */
    SRC_ERROR(417, "来源有误"),
    /**
     * 组织不存在
     */
    UNIT_NOT_EXISTS(404, "组织不存在"),
    /**
     * 产品不存在
     */
    PRODUCT_NOT_EXISTS(404, "产品不存在"),
    /**
     * 订单不能重复取消
     */
    ORDER_CANNOT_BE_CANCELLED_REPEATEDLY(403, "订单不能重复取消");

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
