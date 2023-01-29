package com.zzr.apollo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.master.dto.QueryBookingMasterPayDTO;
import com.zzr.apollo.model.BookingMasterPayDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单支付 Mapper 接口
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:14
 */
public interface BookingMasterPayMapper extends ZzrMapper<BookingMasterPayDO> {
    /**
     * 分页查询
     *
     * @param page
     * @param payDTO
     * @return
     */
    List<BookingMasterPayDO> selectPayPage(IPage page, @Param("entity") QueryBookingMasterPayDTO payDTO);
}
