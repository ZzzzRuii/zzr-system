package com.zzr.apollo.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.zzr.apollo.master.dto.CreateBookingItemCancelRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingItemCancelRuleDTO;
import com.zzr.apollo.master.vo.BookingItemCancelRuleVO;
import com.zzr.apollo.model.BookingItemCancelRuleDO;

import java.util.Objects;

/**
 * 子订单退改规则包装类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:30
 */
public class BookingItemCancelRuleWrapper extends BaseEntityWrapper<BookingItemCancelRuleDO, BookingItemCancelRuleVO> {

    public static BookingItemCancelRuleWrapper build() {
        return new BookingItemCancelRuleWrapper();
    }

    @Override
    public BookingItemCancelRuleVO entityVO(BookingItemCancelRuleDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingItemCancelRuleVO.class));
    }

    @Override
    public BookingItemCancelRuleDO voEntity(BookingItemCancelRuleVO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingItemCancelRuleDO.class));
    }

    public BookingItemCancelRuleDO dtoEntity(CreateBookingItemCancelRuleDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingItemCancelRuleDO.class));
    }

    public BookingItemCancelRuleDO dtoEntity(UpdateBookingItemCancelRuleDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingItemCancelRuleDO.class));
    }
}
