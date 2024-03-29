package com.zzr.apollo.master.vo;

import com.zzr.base.model.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 子订单退款视图实体类
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/8/30 10:12
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BookingMasterRefundItemVO对象", description = "子订单退款")
public class BookingMasterRefundItemVO extends BaseVO {
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
     * booking_master_item_id 子订单id
     */
    @ApiModelProperty(value = "booking_master_item_id 子订单id")
    private Long orderItemId;
    /**
     * order_master_id
     */
    @ApiModelProperty(value = "order_master_refund_id 主订单退款id")
    private Long orderId;
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
    @ApiModelProperty(value = "产品id")
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
     * 价格
     */
    @ApiModelProperty(value = "价格")
    private BigDecimal price;
    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private BigDecimal num;
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
     * 货币单位  人民币  积分，或者其他货币类型
     */
    @ApiModelProperty(value = "货币单位  人民币  积分，或者其他货币类型")
    private String currency;
}
