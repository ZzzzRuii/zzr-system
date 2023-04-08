/*
 * Copyright (c) 2021-2031, FOXHIS All rights reserved.
 */
package com.zzr.apollo.master.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 主订单视图实体类
 *
 * @author FOXHIS
 * @since 2022-06-10
 */

@Data
@ToString
@ApiModel(value = "BookingMasterDTO对象", description = "主订单")
public class QueryBookingMasterDTO implements Serializable {
    /**
     * 租户code tenant.code
     */
    @ApiModelProperty("租户code tenant.code")
    private String tenantId;
    /**
     * 发行单位ID
     */
    private Long unitId;
    /**
     * 发行单位类型
     */
    private String unitType;
    /**
     * 第三方订单号
     */
    private String extOrderNo;
    /**
     * 渠道id
     */
    private Long channelId;
    /**
     * 协议单位档案号
     */
    private Long companyId;
    /**
     * 市场代码
     */
    private String market;
    /**
     * 来源代码
     */
    private String source;
    /**
     * 会员Id
     */
    private Long memberId;
    /**
     * 付款方式
     */
    private String payType;
    /**
     * 付款状态
     */
    private String paymentStatus;
    /**
     * 总金额
     */
    private BigDecimal totalFee;
    /**
     * 折扣金额
     */
    private BigDecimal discountFee;
    /**
     * 实际订单金额
     */
    private BigDecimal finalFee;
    /**
     * 如果是第三方订单，合作伙伴编码
     */
    private String partnerId;
    /**
     * 货币单位  人民币  积分，或者其他货币类型
     */
    private String currency;
    /**
     * 付款时间
     */
    private LocalDateTime payTime;
    /**
     * 发货时间  或者 确认时间 或者 订单完成下发到业务时间
     */
    private LocalDateTime consignTime;
    /**
     * 取消时间
     */
    private LocalDateTime cancelTime;
    /**
     * 审核时间
     */
    private LocalDateTime auditTime;
    /**
     * 完成时间  或者 订单全部项目完成核销时间
     */
    private LocalDateTime endTime;
    /**
     * 是否已审核
     */
    private Boolean isAudit;
    /**
     * 审核人
     */
    private Long auditor;
    /**
     * 买家备注
     */
    private String buyMemo;
    /**
     * 卖家备注
     */
    private String sellerMemo;
    /**
     * 是否是预售订单  期票
     */
    private Boolean isPreSale;
    /**
     * 订单类型  F 散客订单  G 团队订单
     */
    private String orderType;
    /**
     * 营销员代码
     */
    private String salesmanCode;

}
