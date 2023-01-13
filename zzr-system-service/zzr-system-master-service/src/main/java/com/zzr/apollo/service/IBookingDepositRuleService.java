package com.zzr.apollo.service;

import com.zzr.apollo.master.dto.CreateBookingDepositRuleDTO;
import com.zzr.apollo.master.dto.QueryBookingDepositRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingDepositRuleDTO;
import com.zzr.apollo.master.vo.BookingDepositRuleVO;
import com.zzr.apollo.model.BookingDepositRuleDO;
import com.zzr.base.service.IZzrService;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;

/**
 * 担保规则 服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:26
 */
public interface IBookingDepositRuleService extends IZzrService<BookingDepositRuleDO> {
    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    BookingDepositRuleDO detail(Long id);

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param bookingDepositRule
     * @return
     */
    Page<BookingDepositRuleVO> selectPage(Query query, QueryBookingDepositRuleDTO bookingDepositRule);

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param bookingDepositRule
     * @param id
     * @return
     */
    Boolean update(UpdateBookingDepositRuleDTO bookingDepositRule, Long id);

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
     * @param bookingDepositRule
     * @return
     */
    BookingDepositRuleDO create(CreateBookingDepositRuleDTO bookingDepositRule);

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
