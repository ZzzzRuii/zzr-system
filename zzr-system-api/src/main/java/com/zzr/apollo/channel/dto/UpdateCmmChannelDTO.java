package com.zzr.apollo.channel.dto;

import com.zzr.apollo.tool.utils.DemoRegexUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 渠道视图实体类
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/9/1 11:08
 */
@Data
@ToString
@ApiModel(value = "CmmChannelDTO对象", description = "渠道")
public class UpdateCmmChannelDTO implements Serializable {
    /**
     * notnull
     * 租户id
     */
    @ApiModelProperty(value = "租户id", required = true)
    @Pattern(regexp = DemoRegexUtil.TENANT_ID, message = "{ROOM.CODE_IS_NOT_SPECIFICATION}")
    private String tenantId;
    /**
     * notnull
     * 渠道代码
     */
    @ApiModelProperty(value = "渠道代码", required = true)
    @Pattern(regexp = DemoRegexUtil.CODE15, message = "{ROOM.CODE_IS_NOT_SPECIFICATION}")
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
    @Pattern(regexp = DemoRegexUtil.NAME100, message = "{ROOM.CODE_IS_NOT_SPECIFICATION}")
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
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private Integer sort;
    /**
     * notnull
     * 状态 activate 激活 inactive 未激活
     */
    @ApiModelProperty(value = "状态 A 激活 D 未激活 P 已发布")
    @NotBlank(message = "{ROOM.DATA_IS_NOT_NULL}")
    private String status;
}
