package com.zzr.apollo.service;

import com.zzr.apollo.channel.dto.CreateCmmChannelDTO;
import com.zzr.apollo.channel.dto.QueryCmmChannelDTO;
import com.zzr.apollo.channel.dto.UpdateCmmChannelDTO;
import com.zzr.apollo.channel.vo.CmmChannelVO;
import com.zzr.apollo.model.CmmChannelDO;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;

/**
 * 渠道服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 16:04
 */
public interface ICmmChannelService extends IZzrService<CmmChannelDO> {
    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    CmmChannelDO detail(Long id);

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param channelDTO
     * @return
     */
    Page<CmmChannelVO> selectPage(Query query, QueryCmmChannelDTO channelDTO);

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param channelDTO
     * @return
     */
    CmmChannelDO create(CreateCmmChannelDTO channelDTO);

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param channelDTO
     * @param id
     * @return
     */
    Boolean update(UpdateCmmChannelDTO channelDTO, Long id);

    /**
     * 根据主键 删除数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean deleteById(Long id);

    /**
     * 根据主键 未激活
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean inactive(Long id);

    /**
     * 根据主键 激活
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean activate(Long id);
}
