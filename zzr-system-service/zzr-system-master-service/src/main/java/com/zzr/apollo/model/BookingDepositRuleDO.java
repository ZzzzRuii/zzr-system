package com.zzr.apollo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zzr.base.model.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 担保规则实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:16
 */
@Data
@ToString
@TableName("booking_deposit_rule")
@EqualsAndHashCode(callSuper = true)
public class BookingDepositRuleDO extends TenantEntity {

    private static final long serialVersionUID = 1L;

    private static final String TABLE_NAME = "BookingDepositRule";
    /**
     * 发行单位ID
     */
    private Long unitId;
    /**
     * 发行单位类型
     */
    private String unitType;
    /**
     * 代码
     */
    private String code;
    /**
     * 担保类型 在 system_dict grp name=deposite_type
     */
    private String type;
    /**
     * 担保模式 总积分百分比，全额，固定值 在system_dict 中定义
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
     * 到店后N天内支付，否是取消订单
     */
    private Integer dueDays;
    /**
     * 预定后多少分钟支付，否则自动取消
     */
    private Integer resMinute;
    /**
     * 产品名称
     */
    private String name;
    /**
     * 是否强制使用
     */
    private Boolean forceToUse;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 备注
     */
    private String remark;
    /**
     * true ,不再受支持，将被删除
     */
    private Boolean isObsolete;
}