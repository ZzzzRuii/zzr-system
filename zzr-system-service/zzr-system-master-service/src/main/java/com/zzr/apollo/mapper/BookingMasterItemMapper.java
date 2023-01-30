package com.zzr.apollo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.master.dto.QueryBookingMasterItemDTO;
import com.zzr.apollo.model.BookingMasterItemDO;
import com.zzr.base.mapper.ZzrMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 子订单 Mapper 接口
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:11
 */
public interface BookingMasterItemMapper extends ZzrMapper<BookingMasterItemDO> {
    /**
     * 子订单信息查询
     *
     * @param page
     * @param bookingMasterItemDTO
     * @return
     */
    List<BookingMasterItemDO> selectMasterItemInfo(IPage<BookingMasterItemDO> page, @Param("entity") QueryBookingMasterItemDTO bookingMasterItemDTO);

    /**
     * 根据 orderId 查询数据
     *
     * @param orderId
     * @return
     */
    List<BookingMasterItemDO> selectByOrderId(Long orderId);
}
