package com.zzr.apollo.model.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 租户实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 15:56
 */
@Data
public class TenantEntity extends BaseDO {
    @ApiModelProperty("租户ID")
    @TableField(
            updateStrategy = FieldStrategy.NEVER
    )
    private String tenantId;
}
