/*
 * Copyright (c) 2021-2031, FOXHIS All rights reserved.
 */
package com.zzr.apollo.master.dto;

import com.zzr.apollo.tool.utils.DemoRegexUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * 子订单视图实体类
 *
 * @author FOXHIS
 * @since 2022-06-10
 */

@Data
@ToString
@ApiModel(value = "BookingMasterItemDTO对象", description = "子订单")
public class CreateBookingMasterItemDTO implements Serializable {
    /**
     * 发行单位ID
     */
    @ApiModelProperty(value = "发行单位ID", required = true)
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private Long unitId;
    /**
     * 发行单位类型
     */
    @ApiModelProperty(value = "发行单位类型", required = true)
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    @Pattern(regexp = DemoRegexUtil.UNIT_TYPE, message = "{ROOM.CODE_IS_NOT_SPECIFICATION}")
    private String unitType;
    /**
     * 租户id
     */
    @ApiModelProperty(value = "租户id", required = true)
    @Pattern(regexp = DemoRegexUtil.TENANT_ID, message = "{ROOM.CODE_IS_NOT_SPECIFICATION}")
    private String tenantId;
    /**
     * 综合产品拆分后 master_item.id
     */
    @ApiModelProperty(value = "综合产品拆分后 master_item.id")
    private Long parentId;
    /**
     * order_master_id
     */
    @ApiModelProperty(value = "order_master_id")
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private Long orderId;
    /**
     * 游玩开始时间
     */
    @ApiModelProperty(value = "游玩开始时间 ")
    private LocalDateTime arr;
    /**
     * 游玩截止时间
     */
    @ApiModelProperty(value = "游玩截止时间")
    private LocalDateTime dep;
    /**
     * 担保规则名称
     */
    @ApiModelProperty(value = "担保规则名称")
    private String depositRuleName;
    /**
     * 担保规则id
     */
    @ApiModelProperty(value = "担保规则id")
    private Long depositRuleId;
    /**
     * 退改规则名称
     */
    @ApiModelProperty(value = "退改规则名称")
    private String cancelRuleName;
    /**
     * 退改规则id
     */
    @ApiModelProperty(value = "退改规则id")
    private Long cancelRuleId;
    /**
     * 价格政策id
     */
    @ApiModelProperty(value = "价格政策id")
    private Long policyId;
    /**
     * 价格政策名称
     */
    @ApiModelProperty(value = "价格政策名称")
    private String policyName;
    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productName;
    /**
     * 产品类型
     */
    @ApiModelProperty(value = "产品类型")
    private String productKind;
    /**
     * 产品id
     */
    @ApiModelProperty(value = "产品id", required = true)
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private Long productId;
    /**
     * 产品代码
     */
    @ApiModelProperty(value = "产品代码")
    private String productCode;
    /**
     * 产品子代码 比如房价码，场次代码等
     */
    @ApiModelProperty(value = "产品子代码 比如房价码，场次代码等")
    private String productSubCode;
    /**
     * 结算价 成本价
     */
    @ApiModelProperty(value = "结算价 成本价")
    private BigDecimal costPrice;
    /**
     * 原价
     */
    @ApiModelProperty(value = "原价")
    private BigDecimal originalPrice;
    /**
     * 最总价格
     */
    @ApiModelProperty(value = "最总价格")
    private BigDecimal price;
    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private BigDecimal num;
    /**
     * 退款数量
     */
    @ApiModelProperty(value = "退款数量")
    private BigDecimal refundNum;
    /**
     * 核销数量
     */
    @ApiModelProperty(value = "核销数量")
    private BigDecimal usedNum;
    /**
     * 业务系统确认号
     */
    @ApiModelProperty(value = "业务系统确认号")
    private String confirmNo;
    /**
     * 业务系统确认时间
     */
    @ApiModelProperty(value = "业务系统确认时间")
    private LocalDateTime confirmTime;
    /**
     * 利润中心id
     */
    @ApiModelProperty(value = "利润中心id")
    private Long profitCenterId;
    /**
     * 总金额
     */
    @ApiModelProperty(value = "总金额")
    private BigDecimal totalFee;
    /**
     * 折扣金额
     */
    @ApiModelProperty(value = "折扣金额")
    private BigDecimal discountFee;
    /**
     * 实际订单金额
     */
    @ApiModelProperty(value = "实际订单金额")
    private BigDecimal finalFee;
    /**
     * 使用人名字
     */
    @ApiModelProperty(value = "使用人名字")
    private String visitorName;
    /**
     * 使用人电话
     */
    @ApiModelProperty(value = "使用人电话")
    private String visitorPhone;
    /**
     * 使用人证件类型
     */
    @ApiModelProperty(value = "使用人证件类型")
    private String visitorIdType;
    /**
     * 证件号码
     */
    @ApiModelProperty(value = "证件号码")
    private String visitorIdNumber;
    /**
     * 有退款
     */
    @ApiModelProperty(value = "有退款")
    private Boolean refund;
    /**
     * 拆分规则
     */
    @ApiModelProperty(value = "拆分规则")
    private String unpackRuleCode;
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
    /**
     * 货币单位  人民币  积分，或者其他货币类型
     */
    @ApiModelProperty(value = "货币单位  人民币  积分，或者其他货币类型")
    private String currency;
}
