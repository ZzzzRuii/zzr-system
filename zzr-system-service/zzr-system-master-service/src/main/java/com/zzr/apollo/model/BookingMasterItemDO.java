package com.zzr.apollo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zzr.apollo.model.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 子订单实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:24
 */
@Data
@ToString
@TableName("booking_master_item")
@EqualsAndHashCode(callSuper = true)
public class BookingMasterItemDO extends TenantEntity {

    private static final long serialVersionUID = 1L;

    private static final String TABLE_NAME = "BookingMasterItem";
    /**
     * 发行单位ID
     */
    private Long unitId;
    /**
     * 发行单位类型
     */
    private String unitType;
    /**
     * 综合产品拆分后 master_item.id
     */
    private Long parentId;
    /**
     * order_master_id
     */
    private Long orderId;
    /**
     * 游玩开始时间
     */
    private LocalDateTime arr;
    /**
     * 游玩截止时间
     */
    private LocalDateTime dep;
    /**
     * 担保规则名称
     */
    private String depositRuleName;
    /**
     * 担保规则id
     */
    private Long depositRuleId;
    /**
     * 退改规则名称
     */
    private String cancelRuleName;
    /**
     * 退改规则id
     */
    private Long cancelRuleId;
    /**
     * 价格政策id
     */
    private Long policyId;
    /**
     * 价格政策名称
     */
    private String policyName;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品类型
     */
    private String productKind;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 产品代码
     */
    private String productCode;
    /**
     * 产品子代码 比如房价码，场次代码等
     */
    private String productSubCode;
    /**
     * 结算价 成本价
     */
    private BigDecimal costPrice;
    /**
     * 原价 standardPrice
     */
    private BigDecimal originalPrice;
    /**
     * 最总价格 realPrice
     */
    private BigDecimal price;
    /**
     * 数量
     */
    private BigDecimal num;
    /**
     * 退款数量
     */
    private BigDecimal refundNum;
    /**
     * 核销数量
     */
    private BigDecimal usedNum;
    /**
     * 业务系统确认号
     */
    private String confirmNo;
    /**
     * 业务系统确认时间
     */
    private LocalDateTime confirmTime;
    /**
     * 利润中心id
     */
    private Long profitCenterId;
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
     * 使用人名字
     */
    private String visitorName;
    /**
     * 使用人电话
     */
    private String visitorPhone;
    /**
     * 使用人证件类型
     */
    private String visitorIdType;
    /**
     * 证件号码
     */
    private String visitorIdNumber;
    /**
     * 有退款
     */
    private Boolean refund;
    /**
     * 拆分规则
     */
    private String unpackRuleCode;
    /**
     * 是否自动核销
     */
    private Boolean isAutoComplete;
    /**
     * 发货时间  或者 确认时间 或者 订单完成下发到业务时间
     */
    private LocalDateTime consignTime;
    /**
     * 取消时间
     */
    private LocalDateTime cancelTime;
    /**
     * 完成时间  或者 订单全部项目完成核销时间
     */
    private LocalDateTime endTime;
    /**
     * 货币单位  人民币  积分，或者其他货币类型
     */
    private String currency;
}