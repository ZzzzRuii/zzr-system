package com.zzr.apollo.channel.vo;

import com.zzr.apollo.model.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 价格视图实体类
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/9/7 10:13
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CmmProductDailyChannelRateVO对象", description = "价格")
public class CmmProductDailyChannelRateVO extends BaseVO {
    /**
     * 租户code tenant.id
     */
    @ApiModelProperty(value = "租户code tenant.id")
    private String tenantId;

    /**
     * 酒店Id  从property中获取
     */
    @ApiModelProperty(value = "酒店Id 从property中获取")
    private Long unitId;

    /**
     * 发行单位类型
     */
    @ApiModelProperty(value = "发行单位类型")
    private String unitType;

    /**
     * 渠道Id
     */
    @ApiModelProperty(value = "渠道Id")
    private Long channelId;

    /**
     * 产品类型
     */
    @ApiModelProperty(value = "产品类型")
    private String productType;

    /**
     * 产品id
     */
    @ApiModelProperty(value = "产品id")
    private Long productId;

    /**
     * 产品代码, 门票是代码，客房是房价码
     */
    @ApiModelProperty(value = "产品代码, 门票是代码，客房是房价码")
    private String productCode;

    /**
     * 产品描述
     */
    @ApiModelProperty(value = "产品描述")
    private String productName;

    /**
     * 时间
     */
    @ApiModelProperty(value = "时间")
    private LocalDate sellDate;

    /**
     * 原价
     */
    @ApiModelProperty(value = "原价")
    private BigDecimal standardPrice;

    /**
     * 卖价
     */
    @ApiModelProperty(value = "卖价")
    private BigDecimal realPrice;

    /**
     * interface  来自接口  manual 手动
     */
    @ApiModelProperty(value = "interface 来自接口 manual 手动")
    private String src;
}
