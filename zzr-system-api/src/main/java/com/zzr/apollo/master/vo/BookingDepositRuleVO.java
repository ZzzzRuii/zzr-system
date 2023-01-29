/*
 * Copyright (c) 2021-2031, FOXHIS All rights reserved.
 */
package com.zzr.apollo.master.vo;

import com.zzr.apollo.model.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;


/**
 * 担保规则视图实体类
 *
 * @author FOXHIS
 * @since 2022-06-10
 */

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BookingDepositRuleVO对象", description = "担保规则")
public class BookingDepositRuleVO extends BaseVO {

    /**
     * 发行单位ID
     */
    @ApiModelProperty(value = "发行单位ID", required = true)
    private Long unitId;
    /**
     * 发行单位类型
     */
    @ApiModelProperty(value = "发行单位类型", required = true)
    private String unitType;
    /**
     * 代码
     */
    @ApiModelProperty(value = "代码", required = true)
    private String code;
    /**
     * 担保类型 在 system_dict grp name=deposite_type
     */
    @ApiModelProperty(value = "担保类型 在 system_dict grp name=deposite_type")
    private String type;
    /**
     * 担保模式 总积分百分比，全额，固定值 在system_dict 中定义
     */
    @ApiModelProperty(value = "担保模式 总积分百分比，全额，固定值 在system_dict 中定义")
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
     * 到店后N天内支付，否是取消订单
     */
    @ApiModelProperty(value = "到店后N天内支付，否是取消订单")
    private Integer dueDays;
    /**
     * 预定后多少分钟支付，否则自动取消
     */
    @ApiModelProperty(value = "预定后多少分钟支付，否则自动取消")
    private Integer resMinute;
    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称", required = true)
    private String name;
    /**
     * 是否强制使用
     */
    @ApiModelProperty(value = "是否强制使用")
    private Boolean forceToUse;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序", required = true)
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
