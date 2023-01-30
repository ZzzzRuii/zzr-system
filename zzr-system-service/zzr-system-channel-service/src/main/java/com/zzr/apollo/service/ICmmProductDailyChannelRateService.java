package com.zzr.apollo.service;

import com.zzr.apollo.channel.dto.CreateCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.dto.QueryCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.dto.UpdateCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.vo.CmmProductDailyChannelRateVO;
import com.zzr.apollo.model.CmmProductDailyChannelRateDO;
import com.zzr.base.service.IZzrService;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;

import java.util.List;

/**
 * 每日价格服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 17:27
 */
public interface ICmmProductDailyChannelRateService extends IZzrService<CmmProductDailyChannelRateDO> {
    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    CmmProductDailyChannelRateDO detail(Long id);

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
     * @param query
     * @param rateDTO
     * @return
     */
    Page<CmmProductDailyChannelRateVO> selectPage(Query query, QueryCmmProductDailyChannelRateDTO rateDTO);

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param rateDTO
     * @return
     */
    List<Long> create(CreateCmmProductDailyChannelRateDTO rateDTO);

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param rateDTO
     * @param id
     * @return
     */
    Boolean update(UpdateCmmProductDailyChannelRateDTO rateDTO, Long id);

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