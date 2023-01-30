package com.zzr.apollo.unit.vo;

import com.zzr.apollo.product.vo.ProductTicketVO;
import com.zzr.base.model.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * 组织架构视图实体类
 *
 * @author ZhouZhiRui
 * @email zzr@foxhis.com
 * @since 2022/8/31 10:45
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SystemUnitChainInfoVO对象", description = "组织架构")
public class SystemUnitChainInfoVO extends BaseVO {
    /**
     * 租户id
     */
    @ApiModelProperty(value = "租户id", required = true)
    private String tenantId;
    /**
     * notnull
     * 组织编码
     */
    @ApiModelProperty(value = "组织编码", required = true)
    private String code;
    /**
     * 父组织id
     */
    @ApiModelProperty(value = "父组织id")
    private Long parentId;
    /**
     * 组织名称
     */
    @ApiModelProperty(value = "组织名称")
    private String name;
    /**
     * notnull
     * 发行单位类型 Tenant, Subsidiary, Property
     */
    @ApiModelProperty(value = "发行单位类型 Tenant, Subsidiary, Property", required = true)
    private String type;
    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String contacts;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String telephone;
    /**
     * 国家
     */
    @ApiModelProperty(value = "国家")
    private String country;
    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private String city;
    /**
     * 区县
     */
    @ApiModelProperty(value = "区县")
    private String district;
    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    private String province;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;
    /**
     * 经纬度
     */
    @ApiModelProperty(value = "经纬度")
    private String location;
    /**
     * 子节点
     */
    @ApiModelProperty(value = "子组织")
    private List<SystemUnitChainInfoVO> children;
    /**
     * 组织下产品
     */
    @ApiModelProperty(value = "组织下产品")
    private List<ProductTicketVO> product;

}
