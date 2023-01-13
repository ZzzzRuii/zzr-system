package com.zzr.apollo.service;

import com.zzr.apollo.master.dto.CreateBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterItemVoucherDTO;
import com.zzr.apollo.model.BookingMasterItemVoucherDO;
import com.zzr.base.service.IZzrService;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;

/**
 * 子订单 票号 服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:45
 */
public interface IBookingMasterItemVoucherService extends IZzrService<BookingMasterItemVoucherDO> {
    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    BookingMasterItemVoucherDO detail(Long id);

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param bookingMasterItemVoucher
     * @return
     */
    Page<BookingMasterItemVoucherDO> selectPage(Query query, QueryBookingMasterItemVoucherDTO bookingMasterItemVoucher);

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @param bookingMasterItemVoucher
     * @return
     */
    void update(UpdateBookingMasterItemVoucherDTO bookingMasterItemVoucher, Long id);
    
    /**
     * 根据主键 删除数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    void deleteById(Long id);

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param bookingMasterItemVoucher
     * @return
     */
    BookingMasterItemVoucherDO create(CreateBookingMasterItemVoucherDTO bookingMasterItemVoucher);

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
