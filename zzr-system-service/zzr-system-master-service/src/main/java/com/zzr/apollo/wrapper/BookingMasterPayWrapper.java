package com.zzr.apollo.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.zzr.apollo.master.dto.CreateBookingMasterPayDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterPayDTO;
import com.zzr.apollo.master.vo.BookingMasterPayVO;
import com.zzr.apollo.model.BookingMasterPayDO;
import com.zzr.base.wrapper.BaseEntityWrapper;

import java.util.Objects;

/**
 * 订单支付包装类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:32
 */
public class BookingMasterPayWrapper extends BaseEntityWrapper<BookingMasterPayDO, BookingMasterPayVO> {

    public static BookingMasterPayWrapper build() {
        return new BookingMasterPayWrapper();
    }

    @Override
    public BookingMasterPayVO entityVO(BookingMasterPayDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingMasterPayVO.class));
    }

    @Override
    public BookingMasterPayDO voEntity(BookingMasterPayVO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingMasterPayDO.class));
    }

    public BookingMasterPayDO voEntity(CreateBookingMasterPayDTO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingMasterPayDO.class));
    }

    public BookingMasterPayDO voEntity(UpdateBookingMasterPayDTO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingMasterPayDO.class));
    }
}
