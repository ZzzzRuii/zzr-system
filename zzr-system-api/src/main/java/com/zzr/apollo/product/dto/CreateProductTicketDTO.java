package com.zzr.apollo.product.dto;

import com.zzr.apollo.tool.utils.DemoRegexUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 产品视图实体类
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/9/2 11:07
 */
@Data
@ToString
@ApiModel(value = "ProductTicketDTO对象", description = "产品")
public class CreateProductTicketDTO implements Serializable {
    /**
     * notnull
     * 租户ID
     */
    @ApiModelProperty(value = "租户ID", required = true)
    @Pattern(regexp = DemoRegexUtil.TENANT_ID, message = "{ROOM.CODE_IS_NOT_SPECIFICATION}")
    private String tenantId;
    /**
     * notnull
     * 发行单位ID
     */
    @ApiModelProperty(value = "发行单位ID", required = true)
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private Long unitId;
    /**
     * notnull
     * 发行单位类型
     */
    @ApiModelProperty(value = "发行单位类型", required = true)
    @Pattern(regexp = DemoRegexUtil.UNIT_TYPE, message = "{ROOM.CODE_IS_NOT_SPECIFICATION}")
    private String unitType;
    /**
     * notnull
     * 产品代码
     */
    @ApiModelProperty(value = "产品代码", required = true)
    @Pattern(regexp = DemoRegexUtil.CODE30, message = "{ROOM.CODE_IS_NOT_SPECIFICATION}")
    private String code;
    /**
     * notnull
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称", required = true)
    @Pattern(regexp = DemoRegexUtil.NAME100, message = "{ROOM.CODE_IS_NOT_SPECIFICATION}")
    private String name;
    /**
     * 渠道ID
     */
    @ApiModelProperty(value = "渠道ID", required = true)
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private Long channelId;
    /**
     * notnull
     * 产品类别
     */
    @ApiModelProperty(value = "产品类别", required = true)
    @Pattern(regexp = DemoRegexUtil.CATALOG15, message = "{ROOM.CODE_IS_NOT_SPECIFICATION}")
    private String catalog;
    /**
     * 货币单位
     */
    @ApiModelProperty(value = "货币单位")
    private String currency;
    /**
     * 标准价格- 门市价
     */
    @ApiModelProperty(value = "标准价格- 门市价")
    private BigDecimal standardPrice;
    /**
     * 成本价
     */
    @ApiModelProperty(value = "成本价")
    private BigDecimal costPrice;
    /**
     * notnull
     * 最终卖价
     */
    @ApiModelProperty(value = "最终卖价", required = true)
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private BigDecimal realPrice;
    /**
     * notnull
     * 排序
     */
    @ApiModelProperty(value = "排序", required = true)
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private Integer sort;
    /**
     * 有效期策略
     */
    @ApiModelProperty(value = "有效期策略")
    private String validityStrategy;
    /**
     * 有效期策略值
     */
    @ApiModelProperty(value = "有效期策略值")
    private String validityStrategyValue;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 库存数量
     */
    @ApiModelProperty(value = "库存数量")
    private Integer num;
    /**
     * 库存控制模式 U 不控制  T 总数量  D 日库存
     */
    @ApiModelProperty(value = "库存控制模式 U 不控制  T 总数量  D 日库存", required = true)
    private String stockMode;
    /**
     * 产品日历 用于控制产品可买的时间和数量
     */
    @ApiModelProperty(value = "产品日历 用于控制产品可买的时间和数量")
    private Long calendarId;
    /**
     * notnull
     * 标签 可以存储多个标签 ，用逗号隔开
     */
    @ApiModelProperty(value = "标签 可以存储多个标签 ，用逗号隔开", required = true)
    @Pattern(regexp = DemoRegexUtil.FLAG50, message = "{ROOM.CODE_IS_NOT_SPECIFICATION}")
    private String flag;
    /**
     * 创建部门
     */
    @ApiModelProperty(value = "创建部门")
    private Long createDept;
}
