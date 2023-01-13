package com.zzr.apollo.service;

import com.zzr.apollo.master.dto.CreateBookingMasterPayDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterPayDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterPayDTO;
import com.zzr.apollo.master.vo.BookingMasterPayVO;
import com.zzr.apollo.model.BookingMasterPayDO;
import com.zzr.base.service.IZzrService;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;

/**
 * 订单支付 服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:49
 */
public interface IBookingMasterPayService extends IZzrService<BookingMasterPayDO> {
    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    BookingMasterPayDO detail(Long id);

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param bookingMasterPay
     * @return
     */
    Page<BookingMasterPayVO> selectPage(Query query, QueryBookingMasterPayDTO bookingMasterPay);

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param bookingMasterPay
     * @param id
     * @return
     */
    Boolean update(UpdateBookingMasterPayDTO bookingMasterPay, Long id);

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
     * @param bookingMasterPay
     * @return
     */
    BookingMasterPayDO create(CreateBookingMasterPayDTO bookingMasterPay);

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
