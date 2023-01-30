package com.zzr.apollo.model;

import com.zzr.base.model.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 主订单和子订单包装实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:22
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class BookingMasterAndItemFacadeDO extends TenantEntity {
    /**
     * 发行单位ID
     */
    private Long unitId;

    /**
     * 发行单位类型
     */
    private String unitType;

    /**
     * 确认号 提供给用户 来获取订单信息
     */
    private String confirmNo;

    /**
     * 第三方订单号
     */
    private String extOrderNo;

    /**
     * 联系人档案Id
     */
    private Long linkContactsId;

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
     * 渠道代码
     */
    private String channelCode;

    /**
     * 协议单位名称
     */
    private String companyName;

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
     * 预订类型
     */
    private String resType;

    /**
     * 会员Id
     */
    private Long memberId;

    /**
     * 会员名称
     */
    private String memberName;

    /**
     * 会员等级
     */
    private String memberGrade;

    /**
     * 付款方式
     */
    private String payType;

    /**
     * 付款状态
     */
    private String paymentStatus;

    /**
     * 游玩时间
     */
    private LocalDateTime travelDate;

    /**
     * 产品数量
     */
    private Integer quantity;

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

    /**
     * RS  预订 RP  已付款 CXL 已取消  RCI 确认中  RC 已确认  DI 执行中  CO 已完成
     */
    private String status;

    /**
     * 子订单
     */
    List<BookingMasterItemDO> item;
}