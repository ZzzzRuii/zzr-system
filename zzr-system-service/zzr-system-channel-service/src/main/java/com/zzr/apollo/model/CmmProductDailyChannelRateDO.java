package com.zzr.apollo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zzr.apollo.model.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 每日价格实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 16:00
 */
@Data
@ToString
@TableName("cmm_product_daily_channel_rate")
@EqualsAndHashCode(callSuper = true)
public class CmmProductDailyChannelRateDO extends TenantEntity {

    private static final long serialVersionUID = 1L;

    private static final String TABLE_NAME = "CmmProductDailyChannelRate";

    /**
     * 酒店Id  从property中获取
     */
    private Long unitId;
    /**
     * 发行单位类型
     */
    private String unitType;
    /**
     * 渠道Id
     */
    private Long channelId;
    /**
     * 产品类型
     */
    private String productType;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 产品代码, 门票是代码，客房是房价码
     */
    private String productCode;
    /**
     * 产品描述
     */
    private String productName;
    /**
     * 时间
     */
    private LocalDate sellDate;
    /**
     * 原价
     */
    private BigDecimal standardPrice;
    /**
     * 卖价
     */
    private BigDecimal realPrice;
    /**
     * interface  来自接口  manual 手动
     */
    private String src;
}
