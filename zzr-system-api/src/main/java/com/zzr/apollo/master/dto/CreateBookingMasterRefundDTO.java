package com.zzr.apollo.master.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 主订单退款视图实体类
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/8/30 13:47
 */
@Data
@ToString
@ApiModel(value = "BookingMasterRefundDTO对象", description = "主订单退款")
public class CreateBookingMasterRefundDTO implements Serializable {
    /**
     * booking_master_.id 主订单id
     */
    @ApiModelProperty(value = "booking_master_.id 主订单id")
    private Long orderId;
}
