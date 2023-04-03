package com.zzr.base.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * BaseVO
 *
 * @author ZhouZhiRui
 * @since 2022/11/28 13:38
 */
@Data
public class BaseVO implements Serializable {
    /**
     * 租户Id
     */
    @ApiModelProperty("租户Id")
    private String tenantId;
    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;
    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private String status;
}
