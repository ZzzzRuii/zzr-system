package com.zzr.apollo.service;

import com.zzr.apollo.master.dto.CreateBookingCancelRuleDTO;
import com.zzr.apollo.master.dto.QueryBookingCancelRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingCancelRuleDTO;
import com.zzr.apollo.master.vo.BookingCancelRuleVO;
import com.zzr.apollo.model.BookingCancelRuleDO;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;

/**
 * 退改规则 服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:18
 */
public interface IBookingCancelRuleService extends IZzrService<BookingCancelRuleDO> {
    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    BookingCancelRuleDO detail(Long id);

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param bookingCancelRule
     * @return
     */
    Page<BookingCancelRuleVO> selectPage(Query query, QueryBookingCancelRuleDTO bookingCancelRule);

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param bookingCancelRule
     * @param id
     * @return
     */
    Boolean update(UpdateBookingCancelRuleDTO bookingCancelRule, Long id);

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
     * @param bookingCancelRule
     * @return
     */
    BookingCancelRuleDO create(CreateBookingCancelRuleDTO bookingCancelRule);

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
