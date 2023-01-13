package com.zzr.apollo.service;

import com.zzr.apollo.master.dto.CreateBookingMasterRefundItemDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterRefundItemDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterRefundItemDTO;
import com.zzr.apollo.master.vo.BookingMasterRefundItemVO;
import com.zzr.apollo.model.BookingMasterRefundItemDO;
import com.zzr.base.service.IZzrService;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;

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
