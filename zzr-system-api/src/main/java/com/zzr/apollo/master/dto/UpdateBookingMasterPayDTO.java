/*
 * Copyright (c) 2021-2031, FOXHIS All rights reserved.
 */
package com.zzr.apollo.master.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

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
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
}
