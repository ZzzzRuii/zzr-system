package com.zzr.apollo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zzr.base.model.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 退改规则实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:15
 */
@Data
@ToString
@TableName("booking_cancel_rule")
@EqualsAndHashCode(callSuper = true)
public class BookingCancelRuleDO extends TenantEntity {

    private static final long serialVersionUID = 1L;

    private static final String TABLE_NAME = "BookingCancelRule";
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
     * 到店后N天前可以取消，否则执行取消规则
     */
    private Integer dueDays;
    /**
     * 提前多少分钟可以取消
     */
    private Integer resMinute;
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
