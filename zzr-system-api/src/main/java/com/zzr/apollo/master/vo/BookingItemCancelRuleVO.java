package com.zzr.apollo.master.vo;

import com.zzr.apollo.model.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 子订单取消规则视图实体类
 *
 * @author ZhouZhiRui , zzr@foxhis.com
 * @since 2022/9/9 16:23
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BookingItemCancelRuleVO", description = "取消规则")
public class BookingItemCancelRuleVO extends BaseVO {

    /**
     * 租户code tenant.code
     */
    @ApiModelProperty("租户code tenant.code")
    private String tenantId;

    /**
     * booking_master.id
     */
    @ApiModelProperty("booking_master.id")
    private Long orderId;

    /**
     * 代码
     */
    @ApiModelProperty("代码")
    private String code;

    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    private String name;

    /**
     * canclx 可以取消， noback 不可取消
     */
    @ApiModelProperty("canclx 可以取消， noback 不可取消")
    private String type;

    /**
     * 取消罚款模块 总积分百分比，全额，固定值 在system_dict 中定义
     */
    @ApiModelProperty("取消罚款模块 总积分百分比，全额，固定值 在system_dict 中定义")
    private String mode;

    /**
     * 订单总金额的百分比
     */
    @ApiModelProperty("订单总金额的百分比")
    private BigDecimal percentage;

    /**
     * 固定金额
     */
    @ApiModelProperty("固定金额")
    private BigDecimal amount;

    /**
     * 到店N天前可以取消，否则执行取消规则
     */
    @ApiModelProperty("到店N天前可以取消，否则执行取消规则")
    private Integer dueDays;

    /**
     * 截止小时分钟 HH:mm:ss
     */
    @ApiModelProperty("截止小时分钟 HH:mm:ss")
    private String endTime;

    /**
     * 提前多少分钟可以 取消
     */
    @ApiModelProperty("提前多少分钟可以 取消")
    private Integer resMinute;

    /**
     * 状态 A:activate 激活 I:inactive 未激活状态 F: frozen停用  C: cancel 注销
     */
    @ApiModelProperty("状态 A:activate 激活 I:inactive 未激活状态 F: frozen停用  C: cancel 注销")
    private String status;
}
