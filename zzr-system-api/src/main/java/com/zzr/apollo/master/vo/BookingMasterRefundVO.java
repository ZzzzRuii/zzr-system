package com.zzr.apollo.master.vo;

import com.zzr.apollo.model.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 主订单退款实体类
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/8/30 9:46
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BookingMasterRefundVO对象", description = "主订单退款")
public class BookingMasterRefundVO extends BaseVO {
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
     * 退款订单号
     */
    @ApiModelProperty(value = "退款订单号", required = true)
    private String refundOrderNo;
    /**
     * booking_master_.id 主订单id
     */
    @ApiModelProperty(value = "booking_master_.id 主订单id")
    private Long orderId;
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
     * 协议单位名称
     */
    @ApiModelProperty(value = "协议单位名称")
    private String companyName;
    /**
     * 协议单位档案号
     */
    @ApiModelProperty(value = "协议单位档案号")
    private Long companyId;
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
     * 产品数量
     */
    @ApiModelProperty(value = "产品数量")
    private BigDecimal quantity;
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
}
