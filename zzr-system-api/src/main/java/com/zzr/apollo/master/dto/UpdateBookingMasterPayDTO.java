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


/**
 * 订单支付视图实体类
 *
 * @author FOXHIS
 * @since 2022-06-10
 */

@Data
@ToString
@ApiModel(value = "BookingMasterPayDTO对象", description = "订单支付")
public class UpdateBookingMasterPayDTO implements Serializable {
    /**
     * booking_master.id
     */
    @ApiModelProperty("booking_master.id")
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
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
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private String transactionCode;

    /**
     * 交易代码描述
     */
    @ApiModelProperty("交易代码描述")
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private String transactionDescription;

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
