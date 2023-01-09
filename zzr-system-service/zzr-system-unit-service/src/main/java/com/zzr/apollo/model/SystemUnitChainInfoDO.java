package com.zzr.apollo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zzr.base.model.entity.TenantEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 组织架构 实体类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/29 15:44
 */
@Data
@ToString
@TableName("system_unit_chain_info")
@EqualsAndHashCode(callSuper = true)
public class SystemUnitChainInfoDO extends TenantEntity {

    private static final long serialVersionUID = 1L;

    private static final String TABLE_NAME = "SystemUnitChainInfo";

    /**
     * notnull
     * 组织编码
     */
    private String code;
    /**
     * 父组织id
     */
    private Long parentId;
    /**
     * 组织名称
     */
    private String name;
    /**
     * notnull
     * 发行单位类型 Tenant, Subsidiary, Property
     */
    private String type;
    /**
     * 联系人
     */
    private String contacts;
    /**
     * 联系电话
     */
    private String telephone;
    /**
     * 国家
     */
    private String country;
    /**
     * 城市
     */
    private String city;
    /**
     * 区县
     */
    private String district;
    /**
     * 省份
     */
    private String province;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 经纬度
     */
    private String location;
}
