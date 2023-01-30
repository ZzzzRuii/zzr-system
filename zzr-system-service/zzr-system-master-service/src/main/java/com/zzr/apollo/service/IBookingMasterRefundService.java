package com.zzr.apollo.service;

import com.zzr.apollo.master.dto.CreateBookingMasterRefundDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterRefundDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterRefundDTO;
import com.zzr.apollo.master.vo.BookingMasterRefundVO;
import com.zzr.apollo.model.BookingMasterRefundDO;
import com.zzr.base.service.IZzrService;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;

/**
 * 主订单退款 服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 14:01
 */
public interface IBookingMasterRefundService extends IZzrService<BookingMasterRefundDO> {
    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    BookingMasterRefundDO detail(Long id);

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param refundDTO
     * @return
     */
    Page<BookingMasterRefundVO> selectPage(Query query, QueryBookingMasterRefundDTO refundDTO);

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param refundDTO
     * @param id
     * @return
     */
    Boolean update(UpdateBookingMasterRefundDTO refundDTO, Long id);

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
     * @param refundDTO
     * @return
     */
    BookingMasterRefundDO create(CreateBookingMasterRefundDTO refundDTO);

    /**
     * 根据主键 修改状态
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @param status
     * @return
     */
    Boolean status(Long id, String status);
}
