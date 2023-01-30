package com.zzr.apollo.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.zzr.apollo.master.dto.CreateBookingDepositRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingDepositRuleDTO;
import com.zzr.apollo.master.vo.BookingDepositRuleVO;
import com.zzr.apollo.model.BookingDepositRuleDO;
import com.zzr.base.wrapper.BaseEntityWrapper;

import java.util.Objects;

/**
 * 担保规则包装类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:29
 */
public class BookingDepositRuleWrapper extends BaseEntityWrapper<BookingDepositRuleDO, BookingDepositRuleVO> {

    public static BookingDepositRuleWrapper build() {
        return new BookingDepositRuleWrapper();
    }

    @Override
    public BookingDepositRuleVO entityVO(BookingDepositRuleDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingDepositRuleVO.class));
    }

    @Override
    public BookingDepositRuleDO voEntity(BookingDepositRuleVO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingDepositRuleDO.class));
    }

    public BookingDepositRuleDO voEntity(CreateBookingDepositRuleDTO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingDepositRuleDO.class));
    }

    public BookingDepositRuleDO voEntity(UpdateBookingDepositRuleDTO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingDepositRuleDO.class));
    }
}