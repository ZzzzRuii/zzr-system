package com.zzr.apollo.service;

import com.zzr.apollo.master.dto.CreateBookingMasterAndItemFacadeDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterAndItemFacadeDTO;
import com.zzr.apollo.master.vo.BookingMasterAndItemFacadeVO;
import com.zzr.apollo.model.BookingMasterAndItemFacadeDO;
import com.zzr.base.service.IZzrService;

import java.util.List;

/**
 * 主，子订单合并服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:39
 */
public interface IBookingMasterAndItemFacadeService extends IZzrService<BookingMasterAndItemFacadeDO> {
    /**
     * 根据参数 查询数据
     * 树形
     *
     * @param facadeDTO
     * @return
     */
    List<BookingMasterAndItemFacadeVO> selectTree(QueryBookingMasterAndItemFacadeDTO facadeDTO);

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param facadeDTO
     * @return
     */
    BookingMasterAndItemFacadeVO create(CreateBookingMasterAndItemFacadeDTO facadeDTO);
}
