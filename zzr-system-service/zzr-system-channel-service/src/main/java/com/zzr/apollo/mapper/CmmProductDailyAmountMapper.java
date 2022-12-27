package com.zzr.apollo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.channel.dto.QueryCmmProductDailyAmountDTO;
import com.zzr.apollo.model.CmmProductDailyAmountDO;
import com.zzr.base.mapper.ZzrMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 每日库存 Mapper 接口
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 17:13
 */
public interface CmmProductDailyAmountMapper extends ZzrMapper<CmmProductDailyAmountDO> {

    /**
     * 库存分页查询
     *
     * @param page
     * @param amountDTO
     * @return
     */
    List<CmmProductDailyAmountDO> selectAmountPage(IPage<CmmProductDailyAmountDO> page, @Param("entity") QueryCmmProductDailyAmountDTO amountDTO);

    /**
     * 根据产品id查询
     *
     * @param productId
     * @return
     */
    List<CmmProductDailyAmountDO> selectByProductId(Long productId);
}
