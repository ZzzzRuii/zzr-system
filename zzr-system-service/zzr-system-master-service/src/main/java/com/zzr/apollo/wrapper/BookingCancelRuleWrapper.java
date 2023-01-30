package com.zzr.apollo.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.zzr.apollo.master.dto.CreateBookingCancelRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingCancelRuleDTO;
import com.zzr.apollo.master.vo.BookingCancelRuleVO;
import com.zzr.apollo.model.BookingCancelRuleDO;
import com.zzr.base.wrapper.BaseEntityWrapper;

import java.util.Objects;

/**
 * 退改规则包装类,返回视图层所需的字段
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:27
 */
public class BookingCancelRuleWrapper extends BaseEntityWrapper<BookingCancelRuleDO, BookingCancelRuleVO> {

    public static BookingCancelRuleWrapper build() {
        return new BookingCancelRuleWrapper();
    }

    @Override
    public BookingCancelRuleVO entityVO(BookingCancelRuleDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingCancelRuleVO.class));
    }

    @Override
    public BookingCancelRuleDO voEntity(BookingCancelRuleVO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingCancelRuleDO.class));
    }

    public BookingCancelRuleDO voEntity(CreateBookingCancelRuleDTO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingCancelRuleDO.class));
    }

    public BookingCancelRuleDO voEntity(UpdateBookingCancelRuleDTO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingCancelRuleDO.class));
    }
}