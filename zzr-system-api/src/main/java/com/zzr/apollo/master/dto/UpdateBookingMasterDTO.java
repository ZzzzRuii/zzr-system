/*
 * Copyright (c) 2021-2031, FOXHIS All rights reserved.
 */
package com.zzr.apollo.master.dto;

import com.zzr.apollo.tool.utils.DemoRegexUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
public class UpdateBookingMasterDTO implements Serializable {
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
     * 确认号 提供给用户 来获取订单信息
     */
    @ApiModelProperty(value = "确认号 提供给用户 来获取订单信息")
    private String confirmNo;
    /**
     * 第三方订单号
     */
    @ApiModelProperty(value = "第三方订单号")
    private String extOrderNo;
    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String linkContacts;
    /**
     * 联系人手机
     */
    @ApiModelProperty(value = "联系人手机")
    private String linkPhone;
    /**
     * 渠道id
     */
    @ApiModelProperty(value = "渠道id")
    private Long channelId;
    /**
     * 渠道编码
     */
    @ApiModelProperty(value = "渠道编码")
    private String channelCode;
    /**
     * 协议但是名称
     */
    @ApiModelProperty(value = "协议但是名称")
    private String companyName;
    /**
     * 协议单位档案号
     */
    @ApiModelProperty(value = "协议单位档案号")
    private Long companyId;
    /**
     * 市场代码
     */
    @ApiModelProperty(value = "市场代码")
    private String market;
    /**
     * 来源代码
     */
    @ApiModelProperty(value = "来源代码")
    private String source;
    /**
     * 预订类型
     */
    @ApiModelProperty(value = "预订类型")
    private String resType;
    /**
     * 会员Id
     */
    @ApiModelProperty(value = "会员Id")
    private Long memberId;
    /**
     * 会员名称
     */
    @ApiModelProperty(value = "会员名称")
    private String memberName;
    /**
     * 会员等级
     */
    @ApiModelProperty(value = "会员等级")
    private String memberGrade;
    /**
     * 付款方式
     */
    @ApiModelProperty(value = "付款方式")
    private String payType;
    /**
     * 付款状态
     */
    @ApiModelProperty(value = "付款状态")
    private String paymentStatus;
    /**
     * 游玩时间
     */
    @ApiModelProperty(value = "游玩时间")
    private LocalDateTime travelDate;
    /**
     * 产品数量
     */
    @ApiModelProperty(value = "产品数量")
    private Integer quantity;
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
     * 如果是第三方订单，合作伙伴编码
     */
    @ApiModelProperty(value = "如果是第三方订单，合作伙伴编码")
    private String partnerId;
    /**
     * 货币单位  人民币  积分，或者其他货币类型
     */
    @ApiModelProperty(value = "货币单位  人民币  积分，或者其他货币类型")
    private String currency;
    /**
     * 付款时间
     */
    @ApiModelProperty(value = "付款时间")
    private LocalDateTime payTime;
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
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private LocalDateTime auditTime;
    /**
     * 完成时间  或者 订单全部项目完成核销时间
     */
    @ApiModelProperty(value = "完成时间  或者 订单全部项目完成核销时间")
    private LocalDateTime endTime;
    /**
     * 是否已审核
     */
    @ApiModelProperty(value = "是否已审核")
    private Boolean isAudit;
    /**
     * 审核人
     */
    @ApiModelProperty(value = "审核人")
    private Long auditor;
    /**
     * 买家备注
     */
    @ApiModelProperty(value = "买家备注")
    private String buyMemo;
    /**
     * 卖家备注
     */
    @ApiModelProperty(value = "卖家备注")
    private String sellerMemo;
    /**
     * 是否是预售订单  期票
     */
    @ApiModelProperty(value = "是否是预售订单  期票")
    private Boolean isPreSale;
    /**
     * 订单类型  F 散客订单  G 团队订单
     */
    @ApiModelProperty(value = "订单类型  F 散客订单  G 团队订单")
    private String orderType;
    /**
     * 营销员代码
     */
    @ApiModelProperty(value = "营销员代码")
    private String salesmanCode;
}
