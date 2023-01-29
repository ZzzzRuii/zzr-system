package com.zzr.apollo.service;

import com.zzr.apollo.master.dto.CreateBookingMasterRefundItemDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterRefundItemDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterRefundItemDTO;
import com.zzr.apollo.master.vo.BookingMasterRefundItemVO;
import com.zzr.apollo.model.BookingMasterRefundItemDO;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;

/**
 * 子订单退款 服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:54
 */
public interface IBookingMasterRefundItemService extends IZzrService<BookingMasterRefundItemDO> {
    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    BookingMasterRefundItemDO detail(Long id);

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param refundItemDTO
     * @return
     */
    Page<BookingMasterRefundItemVO> selectPage(Query query, QueryBookingMasterRefundItemDTO refundItemDTO);

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param refundItemDTO
     * @param id
     * @return
     */
    Boolean update(UpdateBookingMasterRefundItemDTO refundItemDTO, Long id);


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
     * @param refundItemDTO
     * @return
     */
    BookingMasterRefundItemDO create(CreateBookingMasterRefundItemDTO refundItemDTO);

    /**
     * 根据主键 修改状态 查询不到数据 ServiceException 异常
     *
     * @param id
     * @param status
     * @return
     */
    Boolean status(Long id, String status);
}
