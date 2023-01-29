package com.zzr.apollo.service;

import com.zzr.apollo.master.dto.CreateBookingMasterDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterDTO;
import com.zzr.apollo.master.vo.BookingMasterVO;
import com.zzr.apollo.model.BookingMasterDO;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;

/**
 * 主订单 服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:51
 */
public interface IBookingMasterService extends IZzrService<BookingMasterDO> {
    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    BookingMasterDO detail(Long id);

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param bookingMaster
     * @return
     */
    Page<BookingMasterVO> selectPage(Query query, QueryBookingMasterDTO bookingMaster);

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param bookingMaster
     * @param id
     * @return
     */
    Boolean update(UpdateBookingMasterDTO bookingMaster, Long id);

    /***
     *   根据主键 删除数据
     *   查询不到数据 ServiceException 异常
     *   @param id
     *  @return
     */
    Boolean deleteById(Long id);

    /***
     *   插入数据
     *   新检查数据是否传 ，存在返回ServiceException 异常
     *   vo 对象检查必填是否有数据
     *   @param bookingMaster
     *  @return
     */
    BookingMasterDO create(CreateBookingMasterDTO bookingMaster);

    /**
     * 根据主键 预付款
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean reserve(Long id);

    /**
     * 根据主键 已付款
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean rePay(Long id);

    /**
     * 根据主键 已取消
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean canceled(Long id);

    /**
     * 根据主键 确认中
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean confirming(Long id);

    /**
     * 根据主键 已确认
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean confirmed(Long id);

    /**
     * 根据主键 执行中
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean doing(Long id);

    /**
     * 根据主键 完成
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean complete(Long id);
}
