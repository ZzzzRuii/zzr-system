package com.zzr.apollo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zzr.apollo.model.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 子订单退款实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:26
 */
@Data
@ToString
@TableName("booking_master_refund_item")
@EqualsAndHashCode(callSuper = true)
public class BookingMasterRefundItemDO extends TenantEntity {

    private static final long serialVersionUID = 1L;

    private static final String TABLE_NAME = "BookingMasterRefundItem";

    /**
     * 发行单位ID
     */
    private Long unitId;
    /**
     * 发行单位类型
     */
    private String unitType;
    /**
     * booking_master_item_id 子订单id
     */
    private Long orderItemId;
    /**
     * order_master_id
     */
    private Long orderId;
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
     * 价格
     */
    private BigDecimal price;
    /**
     * 数量
     */
    private BigDecimal num;
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
     * 货币单位  人民币  积分，或者其他货币类型
     */
    private String currency;
}
