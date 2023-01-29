package com.zzr.apollo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.master.dto.QueryBookingItemCancelRuleDTO;
import com.zzr.apollo.model.BookingItemCancelRuleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 取消规则 Mapper 接口
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:10
 */
public interface BookingItemCancelRuleMapper extends ZzrMapper<BookingItemCancelRuleDO> {
    /**
     * 分页查询
     *
     * @param page
     * @param itemCancelRuleDTO
     * @return
     */
    List<BookingItemCancelRuleDO> selectItemCancelRulePage(IPage page, @Param("entity") QueryBookingItemCancelRuleDTO itemCancelRuleDTO);
}
