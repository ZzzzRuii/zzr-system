package com.zzr.apollo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zzr.base.model.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 子订单取消规则实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:22
 */
@Data
@ToString
@TableName("booking_item_cancel_rule")
@EqualsAndHashCode(callSuper = true)
public class BookingItemCancelRuleDO extends TenantEntity {

    private static final long serialVersionUID = 1L;

    private static final String TABLE_NAME = "BookingItemCancelRule";

    /**
     * 租户code tenant.code
     */
    private String tenantId;

    /**
     * booking_master.id
     */
    private Long orderId;

    /**
     * 代码
     */
    private String code;

    /**
     * 产品名称
     */
    private String name;

    /**
     * canclx 可以取消， noback 不可取消
     */
    private String type;

    /**
     * 取消罚款模块 总积分百分比，全额，固定值 在system_dict 中定义
     */
    private String mode;

    /**
     * 订单总金额的百分比
     */
    private BigDecimal percentage;

    /**
     * 固定金额
     */
    private BigDecimal amount;

    /**
     * 到店N天前可以取消，否则执行取消规则
     */
    private Integer dueDays;

    /**
     * 截止小时分钟 HH:mm:ss
     */
    private String endTime;

    /**
     * 提前多少分钟可以 取消
     */
    private Integer resMinute;
}
