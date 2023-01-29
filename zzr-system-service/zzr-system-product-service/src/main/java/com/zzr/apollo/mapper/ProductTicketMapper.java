package com.zzr.apollo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.model.ProductTicketDO;
import com.zzr.apollo.product.dto.QueryProductTicketDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品 Mapper 接口
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/9 17:58
 */
public interface ProductTicketMapper extends ZzrMapper<ProductTicketDO> {

    /**
     * 根据条件查询渠道信息
     *
     * @param page
     * @param productDTO
     * @return
     */
    List<ProductTicketDO> selectProductPage(IPage<ProductTicketDO> page, @Param("entity") QueryProductTicketDTO productDTO);

    /**
     * 根据条件查询渠道信息
     *
     * @param productDTO
     * @return
     */
    List<ProductTicketDO> selectProductList(@Param("entity") QueryProductTicketDTO productDTO);

    /**
     * 联表查询存在的channel_id
     *
     * @return
     */
    List<Long> selectInCmmChannel();

    /**
     * 联表查询存在的unit_id，unit_type , tenant_id
     *
     * @return
     */
    List<ProductTicketDO> selectInSystemUnitChainInfo();
}
