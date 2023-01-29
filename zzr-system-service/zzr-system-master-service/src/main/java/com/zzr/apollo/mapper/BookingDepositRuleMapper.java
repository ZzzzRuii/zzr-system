package com.zzr.apollo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.master.dto.QueryBookingDepositRuleDTO;
import com.zzr.apollo.model.BookingDepositRuleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 担保规则 Mapper 接口
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:08
 */
public interface BookingDepositRuleMapper extends ZzrMapper<BookingDepositRuleDO> {
    /**
     * 分页查询
     *
     * @param page
     * @param bookingDepositRule
     * @return
     */
    List<BookingDepositRuleDO> selectDepositRulePage(IPage page, @Param("entity") QueryBookingDepositRuleDTO bookingDepositRule);

    /**
     * 联表查询组织信息
     *
     * @param unitId
     * @return
     */
    BookingDepositRuleDO selectByUnitId(Long unitId);
}
