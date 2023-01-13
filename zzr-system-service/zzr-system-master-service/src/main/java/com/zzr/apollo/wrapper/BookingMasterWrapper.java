package com.zzr.apollo.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.zzr.apollo.master.dto.CreateBookingMasterDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterDTO;
import com.zzr.apollo.master.vo.BookingMasterVO;
import com.zzr.apollo.model.BookingMasterAndItemFacadeDO;
import com.zzr.apollo.model.BookingMasterDO;
import com.zzr.base.wrapper.BaseEntityWrapper;

import java.util.Objects;

/**
 * 主订单包装类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 11:34
 */
public class BookingMasterWrapper extends BaseEntityWrapper<BookingMasterDO, BookingMasterVO> {

    public static BookingMasterWrapper build() {
        return new BookingMasterWrapper();
    }

    @Override
    public BookingMasterVO entityVO(BookingMasterDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingMasterVO.class));
    }

    @Override
    public BookingMasterDO voEntity(BookingMasterVO vo) {
        return Objects.requireNonNull(BeanUtil.copyProperties(vo, BookingMasterDO.class));
    }

    public BookingMasterDO voEntity(CreateBookingMasterDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingMasterDO.class));
    }

    public BookingMasterDO voEntity(UpdateBookingMasterDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingMasterDO.class));
    }

    public BookingMasterDO facadeEntity(BookingMasterAndItemFacadeDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, BookingMasterDO.class));
    }
}
