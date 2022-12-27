package com.zzr.apollo.service;

import com.zzr.apollo.channel.dto.CreateCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.dto.QueryCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.dto.UpdateCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.vo.CmmProductDailyAmountVO;
import com.zzr.apollo.model.CmmProductDailyAmountDO;
import com.zzr.base.service.IZzrService;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;

import java.util.List;

/**
 * 每日库存服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 17:12
 */
public interface ICmmProductDailyAmountService extends IZzrService<CmmProductDailyAmountDO> {
    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    CmmProductDailyAmountDO detail(Long id);

    /**
     * 根据产品ID查询
     *
     * @param productId
     * @return
     */
    List<CmmProductDailyAmountDO> selectByProductId(Long productId);

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param amountDTO
     * @return
     */
    Page<CmmProductDailyAmountVO> selectPage(Query query, QueryCmmProductDailyAmountDTO amountDTO);

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param amountDTO
     * @return
     */
    List<Long> create(CreateCmmProductDailyAmountDTO amountDTO);

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param amountDTO
     * @param id
     * @return
     */
    Boolean update(UpdateCmmProductDailyAmountDTO amountDTO, Long id);

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