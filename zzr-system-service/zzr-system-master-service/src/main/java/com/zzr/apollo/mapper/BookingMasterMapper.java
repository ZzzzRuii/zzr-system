package com.zzr.apollo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.master.dto.QueryBookingMasterDTO;
import com.zzr.apollo.model.BookingMasterDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 主订单 Mapper 接口
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:12
 */
public interface BookingMasterMapper extends ZzrMapper<BookingMasterDO> {
    /**
     * 查询全部订单信息
     *
     * @param page
     * @param bookingMasterDTO
     * @return
     */
    List<BookingMasterDO> selectMasterInfo(IPage<BookingMasterDO> page, @Param("entity") QueryBookingMasterDTO bookingMasterDTO);

    /**
     * 联表查询组织信息
     *
     * @param unitId
     * @return
     */
    BookingMasterDO selectByUnitId(Long unitId);
}
