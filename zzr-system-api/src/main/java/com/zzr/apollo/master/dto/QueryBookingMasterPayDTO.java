/*
 * Copyright (c) 2021-2031, FOXHIS All rights reserved.
 */
package com.zzr.apollo.master.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 订单支付视图实体类
 *
 * @author FOXHIS
 * @since 2022-06-10
 */

@Data
@ToString
@ApiModel(value = "BookingMasterPayDTO对象", description = "订单支付")
public class QueryBookingMasterPayDTO implements Serializable {
    /**
     * 租户code tenant.code
     */
    @ApiModelProperty("租户code tenant.code")
    private String tenantId;

    /**
     * booking_master.id
     */
    @ApiModelProperty("booking_master.id")
    private Long orderId;

    /**
     * booking_master_item.id
     */
    @ApiModelProperty("booking_master_item.id")
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private Long orderItemId;

    /**
     * 交易代码
     */
    @ApiModelProperty("交易代码")
    private String transactionCode;

    /**
     * 交易代码描述
     */
    @ApiModelProperty("交易代码描述")
    private String transactionDescription;

    /**
     * 消费金额
     */
    @ApiModelProperty("消费金额")
    private BigDecimal amount;

    /**
     * 货币单位  人民币  积分，或者其他货币类型
     */
    @ApiModelProperty("货币单位  人民币  积分，或者其他货币类型")
    private String currency;

    /**
     * 支付系统生成的订单号
     */
    @ApiModelProperty("支付系统生成的订单号")
    private String outTradeNo;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

}
