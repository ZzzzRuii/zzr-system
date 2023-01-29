package com.zzr.apollo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.master.dto.QueryBookingCancelRuleDTO;
import com.zzr.apollo.model.BookingCancelRuleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 退改规则 Mapper 接口
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:06
 */
public interface BookingCancelRuleMapper extends ZzrMapper<BookingCancelRuleDO> {
    /**
     * 分页查询
     *
     * @param page
     * @param bookingCancelRule
     * @return
     */
    List<BookingCancelRuleDO> selectCancelPage(IPage page, @Param("entity") QueryBookingCancelRuleDTO bookingCancelRule);

    /**
     * 联表查询组织信息
     *
     * @param unitId
     * @return
     */
    BookingCancelRuleDO selectByUnitId(Long unitId);
}