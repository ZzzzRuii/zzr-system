package com.zzr.apollo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.master.dto.QueryBookingMasterRefundItemDTO;
import com.zzr.apollo.model.BookingMasterRefundItemDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 子订单退款 Mapper 接口
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:15
 */
public interface BookingMasterRefundItemMapper extends ZzrMapper<BookingMasterRefundItemDO> {
    /**
     * 子订单退款全部信息查询
     *
     * @param page
     * @param refundItemDTO
     * @return
     */
    List<BookingMasterRefundItemDO> selectMasterRefundItemInfo(IPage<BookingMasterRefundItemDO> page, @Param("entity") QueryBookingMasterRefundItemDTO refundItemDTO);
}
