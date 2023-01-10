package com.zzr.apollo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zzr.base.model.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 产品实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/9 17:54
 */
@Data
@ToString
@TableName("product_ticket")
@EqualsAndHashCode(callSuper = true)
public class ProductTicketDO extends TenantEntity {

    private static final long serialVersionUID = 1L;

    private static final String TABLE_NAME = "ProductTicket";

    /**
     * notnull
     * 发行单位ID
     */
    private Long unitId;
    /**
     * notnull
     * 发行单位类型
     */
    private String unitType;
    /**
     * notnull
     * 产品代码
     */
    private String code;
    /**
     * notnull
     * 产品名称
     */
    private String name;
    /**
     * 渠道ID
     */
    private Long channelId;
    /**
     * 产品类别
     */
    private String catalog;
    /**
     * 货币单位
     */
    private String currency;
    /**
     * 标准价格- 门市价
     */
    private BigDecimal standardPrice;
    /**
     * 成本价
     */
    private BigDecimal costPrice;
    /**
     * notnull
     * 最终卖价
     */
    private BigDecimal realPrice;
    /**
     * notnull
     * 排序
     */
    private Integer sort;
    /**
     * 有效期策略
     */
    private String validityStrategy;
    /**
     * 有效期策略值
     */
    private String validityStrategyValue;
    /**
     * 备注
     */
    private String remark;
    /**
     * 库存数量
     */
    private Integer num;
    /**
     * 库存控制模式 N 不控制  T 总数量  D 日库存  C 产品日历
     */
    private String stockMode;
    /**
     * 产品日历 用于控制产品可买的时间和数量
     */
    private Long calendarId;
    /**
     * 标签 可以存储多个标签 ，用逗号隔开
     */
    private String flag;
    /**
     * 创建部门
     */
    private Long createDept;
}