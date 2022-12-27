/*
 * Copyright (c) 2021-2031, FOXHIS All rights reserved.
 */
package com.zzr.apollo.master.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 子订单 票号视图实体类
 *
 * @author FOXHIS
 * @since 2022-06-10
 */

@Data
@ToString
@ApiModel(value = "BookingMasterItemVoucherDTO对象", description = "子订单 票号")
public class UpdateBookingMasterItemVoucherDTO implements Serializable {
    /**
     * order_master_item.id
     */
    @ApiModelProperty(value = "order_master_item.id")
    private Long orderItemId;
    /**
     * 游玩开始时间
     */
    @ApiModelProperty(value = "游玩开始时间")
    private LocalDateTime arr;
    /**
     * 游玩结束时间
     */
    @ApiModelProperty(value = "游玩结束时间")
    private LocalDateTime dep;
    /**
     * 票号
     */
    @ApiModelProperty(value = "票号")
    private String voucher;
    /**
     * 二维码图片url地址
     */
    @ApiModelProperty(value = "二维码图片url地址")
    private String voucherImgage;
    /**
     * 是否自动核销
     */
    @ApiModelProperty(value = "是否自动核销")
    private Boolean isAutoComplete;
    /**
     * 发货时间  或者 确认时间 或者 订单完成下发到业务时间
     */
    @ApiModelProperty(value = "发货时间  或者 确认时间 或者 订单完成下发到业务时间")
    private LocalDateTime consignTime;
    /**
     * 取消时间
     */
    @ApiModelProperty(value = "取消时间")
    private LocalDateTime cancelTime;
    /**
     * 完成时间  或者 订单全部项目完成核销时间
     */
    @ApiModelProperty(value = "完成时间  或者 订单全部项目完成核销时间")
    private LocalDateTime endTime;
}
