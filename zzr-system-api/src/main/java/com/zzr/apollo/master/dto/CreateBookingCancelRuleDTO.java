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
 * 退改规则视图实体类
 *
 * @author FOXHIS
 * @since 2022-06-10
 */

@Data
@ToString
@ApiModel(value = "BookingCancelRuleDTO对象", description = "退改规则")
public class CreateBookingCancelRuleDTO implements Serializable {
    /**
     * 主订单id
     */
    @ApiModelProperty(value = "子订单id", required = true)
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private Long orderId;
    /**
     * 发行单位ID
     */
    @ApiModelProperty(value = "发行单位ID", required = true)
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private Long unitId;
    /**
     * 代码
     */
    @ApiModelProperty(value = "代码", required = true)
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private String code;
    /**
     * canclx 可以取消， noback 不可取消
     */
    @ApiModelProperty(value = "canclx 可以取消， noback 不可取消")
    private String type;
    /**
     * 取消罚款模块 总积分百分比，全额，固定值 在system_dict 中定义
     */
    @ApiModelProperty(value = "取消罚款模块 总积分百分比，全额，固定值 在system_dict 中定义")
    private String mode;
    /**
     * 订单总金额的百分比
     */
    @ApiModelProperty(value = "订单总金额的百分比")
    private BigDecimal percentage;
    /**
     * 固定金额
     */
    @ApiModelProperty(value = "固定金额")
    private BigDecimal amount;
    /**
     * 到店后N天前可以取消，否则执行取消规则
     */
    @ApiModelProperty(value = "到店后N天前可以取消，否则执行取消规则")
    private Integer dueDays;
    /**
     * 是否强制使用
     */
    @ApiModelProperty(value = "是否强制使用")
    private Boolean forceToUse;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序", required = true)
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private Integer sort;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * true ,不再受支持，将被删除
     */
    @ApiModelProperty(value = "true ,不再受支持，将被删除")
    private Boolean isObsolete;
}
