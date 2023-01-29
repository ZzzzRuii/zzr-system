package com.zzr.apollo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zzr.apollo.model.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 子订单 票号实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:25
 */
@Data
@ToString
@TableName("booking_master_item_voucher")
@EqualsAndHashCode(callSuper = true)
public class BookingMasterItemVoucherDO extends TenantEntity {

    private static final long serialVersionUID = 1L;

    private static final String TABLE_NAME = "BookingMasterItemVoucher";
    /**
     * 子订单id
     * order_master_item.id
     */
    private Long orderItemId;
    /**
     * 游玩开始时间
     */
    private LocalDateTime arr;
    /**
     * 游玩结束时间
     */
    private LocalDateTime dep;
    /**
     * 票号
     */
    private String voucher;
    /**
     * 二维码图片url地址
     */
    private String voucherImgage;
    /**
     * 是否自动核销
     */
    private Boolean isAutoComplete;
    /**
     * 发货时间  或者 确认时间 或者 订单完成下发到业务时间
     */
    private LocalDateTime consignTime;
    /**
     * 取消时间
     */
    private LocalDateTime cancelTime;
    /**
     * 完成时间  或者 订单全部项目完成核销时间
     */
    private LocalDateTime endTime;
}