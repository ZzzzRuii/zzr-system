package com.zzr.apollo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.master.dto.QueryBookingMasterRefundDTO;
import com.zzr.apollo.model.BookingMasterRefundDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 主订单退款 Mapper 接口
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:16
 */
public interface BookingMasterRefundMapper extends ZzrMapper<BookingMasterRefundDO> {
    /**
     * 查询全部主订单退款信息
     *
     * @param page
     * @param refundDTO
     * @return
     */
    List<BookingMasterRefundDO> selectMasterRefundInfo(IPage<BookingMasterRefundDO> page, @Param("entity") QueryBookingMasterRefundDTO refundDTO);
}
