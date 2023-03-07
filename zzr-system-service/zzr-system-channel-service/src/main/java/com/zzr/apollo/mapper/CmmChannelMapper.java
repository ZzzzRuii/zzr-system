package com.zzr.apollo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.channel.dto.QueryCmmChannelDTO;
import com.zzr.apollo.model.CmmChannelDO;
import com.zzr.base.mapper.ZzrMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 渠道 Mapper 接口
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 16:22
 */
public interface CmmChannelMapper extends ZzrMapper<CmmChannelDO> {

    /**
     * 根据条件查询渠道信息
     *
     * @param page
     * @param channelDTO
     * @return
     */
    List<CmmChannelDO> selectChannelPage(IPage<CmmChannelDO> page, @Param("entity") QueryCmmChannelDTO channelDTO);

    /**
     * 根据条件查询渠道信息
     *
     * @param channelDTO
     * @return
     */
    List<CmmChannelDO> selectChannelList(@Param("entity") QueryCmmChannelDTO channelDTO);

}