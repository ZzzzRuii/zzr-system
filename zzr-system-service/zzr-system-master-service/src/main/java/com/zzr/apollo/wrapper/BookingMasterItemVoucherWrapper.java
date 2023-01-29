package com.zzr.apollo.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.zzr.apollo.master.dto.CreateBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.vo.BookingMasterItemVoucherVO;
import com.zzr.apollo.model.BookingMasterItemVoucherDO;

import java.util.Objects;

/**
 * 子订单 票号包装类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:30
 */
public class BookingMasterItemVoucherWrapper extends BaseEntityWrapper<BookingMasterItemVoucherDO, BookingMasterItemVoucherVO> {

    public static BookingMasterItemVoucherWrapper build() {
        return new BookingMasterItemVoucherWrapper();
    }

    @Override
    public BookingMasterItemVoucherVO entityVO(BookingMasterItemVoucherDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingMasterItemVoucherVO.class));
    }

    @Override
    public BookingMasterItemVoucherDO voEntity(BookingMasterItemVoucherVO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingMasterItemVoucherDO.class));
    }

    public BookingMasterItemVoucherDO voEntity(CreateBookingMasterItemVoucherDTO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingMasterItemVoucherDO.class));
    }

    public BookingMasterItemVoucherDO voEntity(UpdateBookingMasterItemVoucherDTO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingMasterItemVoucherDO.class));
    }
}
