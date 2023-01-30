package com.zzr.apollo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zzr.base.model.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 渠道实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 15:54
 */
@Data
@ToString
@TableName("cmm_channel")
@EqualsAndHashCode(callSuper = true)
public class CmmChannelDO extends TenantEntity {

    private static final long serialVersionUID = 1L;

    private static final String TABLE_NAME = "CmmChannel";

    /**
     * notnull
     * 渠道代码
     */
    private String code;
    /**
     * 渠道类别 自营 非自营 等
     */
    private String type;
    /**
     * notnull
     * 名称
     */
    private String name;
    /**
     * 标签
     */
    private String flag;
    /**
     * 是否开启价格校验 ，开启价格校验后，以系统定义的价格为准
     */
    private Boolean isVerificationPrice;
    /**
     * 担保规则id
     */
    private Long guaranteeTypeId;
    /**
     * 退改规则id
     */
    private Long cancelTypeId;
    /**
     * 备注
     */
    private String remark;
    /**
     * notnull
     * 排序
     */
    private Integer sort;
}
