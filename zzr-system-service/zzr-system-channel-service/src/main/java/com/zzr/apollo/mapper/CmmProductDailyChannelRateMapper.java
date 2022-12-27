package com.zzr.apollo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.channel.dto.QueryCmmProductDailyChannelRateDTO;
import com.zzr.apollo.model.CmmProductDailyChannelRateDO;
import com.zzr.base.mapper.ZzrMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 每日价格 Mapper 接口
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 17:29
 */
public interface CmmProductDailyChannelRateMapper extends ZzrMapper<CmmProductDailyChannelRateDO> {

    /**
     * 根据产品ID查询
     *
     * @param productId
     * @return
     */
    List<CmmProductDailyChannelRateDO> selectByProductId(Long productId);

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param page
     * @param rateDTO
     * @return
     */
    List<CmmProductDailyChannelRateDO> selectRatePage(IPage<CmmProductDailyChannelRateDO> page, @Param("entity") QueryCmmProductDailyChannelRateDTO rateDTO);
}
