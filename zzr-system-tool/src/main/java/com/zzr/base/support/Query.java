package com.zzr.base.support;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Query
 *
 * @author ZhouZhiRui
 * @since 2022/11/28 16:22
 */
@Data
public class Query {
    @ApiModelProperty("当前页")
    private Integer current;
    @ApiModelProperty("每页的数量")
    private Integer size;
    @ApiModelProperty(
            hidden = true
    )
    private String asc;
    @ApiModelProperty(
            hidden = true
    )
    private String desc;
}
