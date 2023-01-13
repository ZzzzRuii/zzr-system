package com.zzr.apollo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zzr.base.model.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 主订单退款实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:26
 */
@Data
@ToString
@TableName("booking_master_refund")
@EqualsAndHashCode(callSuper = true)
public class BookingMasterRefundDO extends TenantEntity {

    private static final long serialVersionUID = 1L;

    private static final String TABLE_NAME = "BookingMasterRefund";

    /**
     * 发行单位ID
     */
    private Long unitId;
    /**
     * 发行单位类型
     */
    private String unitType;
    /**
     * 退款订单号
     */
    private String refundOrderNo;
    /**
     * booking_master_.id 主订单id
     */
    private Long orderId;
    /**
     * 联系人
     */
    private String linkContacts;
    /**
     * 联系人手机
     */
    private String linkPhone;
    /**
     * 渠道id
     */
    private Long channelId;
    /**
     * 协议单位名称
     */
    private String companyName;
    /**
     * 协议单位档案号
     */
    private Long companyId;
    /**
     * 付款方式
     */
    private String payType;
    /**
     * 付款状态
     */
    private String paymentStatus;
    /**
     * 产品数量
     */
    private BigDecimal quantity;
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
}