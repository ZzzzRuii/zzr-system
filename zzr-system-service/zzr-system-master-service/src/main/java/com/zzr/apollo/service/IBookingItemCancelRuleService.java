package com.zzr.apollo.service;

import com.zzr.apollo.master.dto.CreateBookingItemCancelRuleDTO;
import com.zzr.apollo.master.dto.QueryBookingItemCancelRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingItemCancelRuleDTO;
import com.zzr.apollo.master.vo.BookingItemCancelRuleVO;
import com.zzr.apollo.model.BookingItemCancelRuleDO;
import com.zzr.base.service.IZzrService;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;

/**
 * 取消规则服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:34
 */
public interface IBookingItemCancelRuleService extends IZzrService<BookingItemCancelRuleDO> {
    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    BookingItemCancelRuleDO detail(Long id);

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param itemCancelRuleDTO
     * @return
     */
    Page<BookingItemCancelRuleVO> selectPage(Query query, QueryBookingItemCancelRuleDTO itemCancelRuleDTO);

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param itemCancelRuleDTO
     * @param id
     * @return
     */
    Boolean update(UpdateBookingItemCancelRuleDTO itemCancelRuleDTO, Long id);
    
    /**
     * 根据主键 删除数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean deleteById(Long id);

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param itemCancelRuleDTO
     * @return
     */
    BookingItemCancelRuleDO create(CreateBookingItemCancelRuleDTO itemCancelRuleDTO);

    /**
     * 根据主键 停用数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean inactivate(Long id);

    /**
     * 根据主键 激活数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean activate(Long id);
}
