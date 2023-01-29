package com.zzr.apollo.channel.vo;

import com.zzr.apollo.model.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 渠道视图实体类
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/9/1 10:50
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CmmChannelVO对象", description = "渠道")
public class CmmChannelVO extends BaseVO {
    /**
     * notnull
     * 租户id
     */
    @ApiModelProperty(value = "租户id", required = true)
    private String tenantId;
    /**
     * notnull
     * 渠道代码
     */
    @ApiModelProperty(value = "渠道代码", required = true)
    private String code;
    /**
     * 渠道类别 自营 非自营 等
     */
    @ApiModelProperty(value = "渠道类别 自营 非自营 等")
    private String type;
    /**
     * notnull
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 标签
     */
    @ApiModelProperty(value = "标签")
    private String flag;
    /**
     * 是否开启价格校验 ，开启价格校验后，以系统定义的价格为准
     */
    @ApiModelProperty(value = "是否开启价格校验 ，开启价格校验后，以系统定义的价格为准")
    private Boolean isVerificationPrice;
    /**
     * 担保规则id
     */
    @ApiModelProperty(value = "担保规则id")
    private Long guaranteeTypeId;
    /**
     * 退改规则id
     */
    @ApiModelProperty(value = "退改规则id")
    private Long cancelTypeId;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * notnull
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;
}
