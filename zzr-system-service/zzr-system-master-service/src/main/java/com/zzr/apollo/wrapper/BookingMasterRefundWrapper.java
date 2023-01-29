package com.zzr.apollo.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.zzr.apollo.master.dto.CreateBookingMasterRefundDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterRefundDTO;
import com.zzr.apollo.master.vo.BookingMasterRefundVO;
import com.zzr.apollo.model.BookingMasterRefundDO;

import java.util.Objects;

/**
 * 主订单退款包装类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:34
 */
public class BookingMasterRefundWrapper extends BaseEntityWrapper<BookingMasterRefundDO, BookingMasterRefundVO> {

    public static BookingMasterRefundWrapper build() {
        return new BookingMasterRefundWrapper();
    }

    @Override
    public BookingMasterRefundVO entityVO(BookingMasterRefundDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingMasterRefundVO.class));
    }

    @Override
    public BookingMasterRefundDO voEntity(BookingMasterRefundVO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingMasterRefundDO.class));
    }

    public BookingMasterRefundDO voEntity(CreateBookingMasterRefundDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingMasterRefundDO.class));
    }

    public BookingMasterRefundDO voEntity(UpdateBookingMasterRefundDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingMasterRefundDO.class));
    }
}
