package com.zzr.apollo.master.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 子订单退款视图实体类
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/8/30 14:22
 */
@Data
@ToString
@ApiModel(value = "BookingMasterRefundItemDTO对象", description = "子订单退款")
public class CreateBookingMasterRefundItemDTO implements Serializable {
    /**
     * booking_master_item_id 子订单id
     */
    @ApiModelProperty(value = "booking_master_item_id 子订单id")
    @NotNull(message = "{ROOM.DATA_IS_NOT_NULL}")
    private Long orderItemId;
}
