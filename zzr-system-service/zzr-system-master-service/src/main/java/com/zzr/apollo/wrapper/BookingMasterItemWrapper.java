package com.zzr.apollo.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.zzr.apollo.master.dto.CreateBookingMasterItemDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterItemDTO;
import com.zzr.apollo.master.vo.BookingMasterItemVO;
import com.zzr.apollo.model.BookingMasterAndItemFacadeDO;
import com.zzr.apollo.model.BookingMasterItemDO;
import com.zzr.base.wrapper.BaseEntityWrapper;

import java.util.Objects;

/**
 * 子订单包装类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:31
 */
public class BookingMasterItemWrapper extends BaseEntityWrapper<BookingMasterItemDO, BookingMasterItemVO> {

    public static BookingMasterItemWrapper build() {
        return new BookingMasterItemWrapper();
    }

    @Override
    public BookingMasterItemVO entityVO(BookingMasterItemDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingMasterItemVO.class));
    }

    @Override
    public BookingMasterItemDO voEntity(BookingMasterItemVO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingMasterItemDO.class));
    }

    public BookingMasterItemDO voEntity(CreateBookingMasterItemDTO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingMasterItemDO.class));
    }

    public BookingMasterItemDO voEntity(UpdateBookingMasterItemDTO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingMasterItemDO.class));
    }

    public BookingMasterItemDO facadeEntity(BookingMasterAndItemFacadeDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingMasterItemDO.class));
    }
}
