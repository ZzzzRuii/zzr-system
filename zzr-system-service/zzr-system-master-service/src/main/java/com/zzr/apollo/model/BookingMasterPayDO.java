package com.zzr.apollo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zzr.apollo.model.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 订单支付实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:25
 */
@Data
@ToString
@TableName("booking_master_pay")
@EqualsAndHashCode(callSuper = true)
public class BookingMasterPayDO extends TenantEntity {

    private static final long serialVersionUID = 1L;

    private static final String TABLE_NAME = "BookingMasterPay";

    /**
     * booking_master.id
     */
    private Long orderId;

    /**
     * 交易代码
     */
    private String transactionCode;

    /**
     * 交易代码描述
     */
    private String transactionDescription;

    /**
     * 消费金额
     */
    private BigDecimal amount;

    /**
     * 货币单位  人民币  积分，或者其他货币类型
     */
    private String currency;

    /**
     * 支付系统生成的订单号
     */
    private String outTradeNo;

    /**
     * 备注
     */
    private String remark;
}