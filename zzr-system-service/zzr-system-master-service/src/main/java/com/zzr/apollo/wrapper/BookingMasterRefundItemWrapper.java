package com.zzr.apollo.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.zzr.apollo.master.dto.CreateBookingMasterRefundItemDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterRefundItemDTO;
import com.zzr.apollo.master.vo.BookingMasterRefundItemVO;
import com.zzr.apollo.model.BookingMasterRefundItemDO;

import java.util.Objects;

/**
 * 子订单退款包装类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:33
 */
public class BookingMasterRefundItemWrapper extends BaseEntityWrapper<BookingMasterRefundItemDO, BookingMasterRefundItemVO> {

    public static BookingMasterRefundItemWrapper build() {
        return new BookingMasterRefundItemWrapper();
    }

    @Override
    public BookingMasterRefundItemVO entityVO(BookingMasterRefundItemDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingMasterRefundItemVO.class));
    }

    @Override
    public BookingMasterRefundItemDO voEntity(BookingMasterRefundItemVO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingMasterRefundItemDO.class));
    }

    public BookingMasterRefundItemDO voEntity(CreateBookingMasterRefundItemDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingMasterRefundItemDO.class));
    }

    public BookingMasterRefundItemDO voEntity(UpdateBookingMasterRefundItemDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingMasterRefundItemDO.class));
    }
}
