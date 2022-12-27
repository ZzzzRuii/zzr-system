/*
 * Copyright (c) 2021-2031, FOXHIS All rights reserved.
 */
package com.zzr.apollo.master.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 子订单视图实体类
 *
 * @author FOXHIS
 * @since 2022-06-10
 */

@Data
@ToString
@ApiModel(value = "BookingMasterItemDTO对象", description = "子订单")
public class QueryBookingMasterItemDTO implements Serializable {
    /**
     * 发行单位ID
     */
    private Long unitId;
    /**
     * 综合产品拆分后 master_item.id
     */
    private Long parentId;
    /**
     * order_master_id
     */
    private Long orderId;
    /**
     * 担保规则id
     */
    private Long depositRuleId;
    /**
     * 退改规则id
     */
    private Long cancelRuleId;
    /**
     * 价格政策id
     */
    private Long policyId;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 利润中心id
     */
    private Long profitCenterId;
    /**
     * 证件号码
     */
    private String visitorIdNumber;

}
