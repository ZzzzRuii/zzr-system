package com.zzr.apollo.channel.vo;

import com.zzr.base.model.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

/**
 * 库存视图实体类
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/9/5 16:08
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CmmProductDailyAmountVO对象", description = "库存")
public class CmmProductDailyAmountVO extends BaseVO {
    /**
     * notnull
     * 租户code tenant.code
     */
    @ApiModelProperty(value = "租户code tenant.code")
    private String tenantId;
    /**
     * 酒店ID 从property中获取
     */
    @ApiModelProperty(value = "酒店ID 从property中获取")
    private Long unitId;
    /**
     * notnull
     * 发行单位类型
     */
    @ApiModelProperty(value = "发行单位类型")
    private String unitType;
    /**
     * notnull
     * 产品类型
     */
    @ApiModelProperty(value = "产品类型")
    private String productType;
    /**
     * 渠道ID
     */
    @ApiModelProperty(value = "渠道ID")
    private Long channelId;
    /**
     * 产品ID
     */
    @ApiModelProperty(value = "产品ID")
    private Long productId;
    /**
     * 产品代码，门票是代码，客房是房价码
     */
    @ApiModelProperty(value = "产品代码，门票是代码，客房是房价码")
    private String productCode;
    /**
     * 房价码 或者场次编码 规则编码
     */
    @ApiModelProperty(value = "房价码 或者场次编码 规则编码")
    private String productSubcode;
    /**
     * Unlimited  U  不限制，D  Daily fixed 每天固定  ,T  Total 控总量  C Calendar 控制
     * <p>
     * 日控时 sell date 才有数据，是否 都是为null
     * <p>
     * D 状态 可以不用产生所有天的数据
     */
    @ApiModelProperty(value = "Unlimited U 不限制，D Daily fixed 每天固定 ,T Total 控总量 C Calendar 控制 日控时 sell date 才有数据，是否 都是为null D 状态 可以不用产生所有天的数据")
    private String model;
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
     * 可卖数量
     */
    @ApiModelProperty(value = "可卖数量")
    private Integer num;
    /**
     * 已用
     */
    @ApiModelProperty(value = "已用")
    private Integer usedNum;
}
