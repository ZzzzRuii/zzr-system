package com.zzr.apollo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zzr.apollo.model.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

/**
 * 每日库存实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 15:59
 */
@Data
@ToString
@TableName("cmm_product_daily_amount")
@EqualsAndHashCode(callSuper = true)
public class CmmProductDailyAmountDO extends TenantEntity {

    private static final long serialVersionUID = 1L;

    private static final String TABLE_NAME = "CmmProductDailyAmount";

    /**
     * 酒店ID 从property中获取
     */
    private Long unitId;
    /**
     * notnull
     * 发行单位类型
     */
    private String unitType;
    /**
     * notnull
     * 产品类型
     */
    private String productType;
    /**
     * 渠道ID
     */
    private Long channelId;
    /**
     * 产品ID
     */
    private Long productId;
    /**
     * 产品代码，门票是代码，客房是房价码
     */
    private String productCode;
    /**
     * 房价码 或者场次编码 规则编码
     */
    private String productSubcode;
    /**
     * Unlimited  U  不限制，D  Daily fixed 每天固定  ,T  Total 控总量  C Calendar 控制
     * <p>
     * 日控时 sell date 才有数据，是否 都是为null
     * <p>
     * D 状态 可以不用产生所有天的数据
     */
    private String model;
    /**
     * 产品描述
     */
    private String productName;
    /**
     * 时间
     */
    private LocalDate sellDate;
    /**
     * 可卖数量
     */
    private Integer num;
    /**
     * 已用
     */
    private Integer usedNum;
}
