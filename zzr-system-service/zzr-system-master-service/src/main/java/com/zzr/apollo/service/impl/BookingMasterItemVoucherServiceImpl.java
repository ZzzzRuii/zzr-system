package com.zzr.apollo.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.zzr.apollo.api.ResultCode;
import com.zzr.apollo.exception.ServiceException;
import com.zzr.apollo.mapper.BookingMasterItemVoucherMapper;
import com.zzr.apollo.master.dto.CreateBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterItemVoucherDTO;
import com.zzr.apollo.model.BookingMasterItemVoucherDO;
import com.zzr.apollo.service.IBookingMasterItemVoucherService;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * BookingMasterItemVoucherServiceImpl
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:45
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BookingMasterItemVoucherServiceImpl extends ZzrServiceImpl<BookingMasterItemVoucherMapper, BookingMasterItemVoucherDO> implements IBookingMasterItemVoucherService {

    @Override
    public BookingMasterItemVoucherDO detail(Long id) {
        return baseMapper.selectById(id);
    }

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param bookingMasterItemVoucher
     * @return
     */
    @Override
    public Page<BookingMasterItemVoucherDO> selectPage(Query query, QueryBookingMasterItemVoucherDTO bookingMasterItemVoucher) {
        throw new UnsupportedOperationException();
    }

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @param bookingMasterItemVoucher
     * @return
     */
    @Override
    public void update(UpdateBookingMasterItemVoucherDTO bookingMasterItemVoucher, Long id) {
        throw new UnsupportedOperationException();
    }


    /**
     * 根据主键 删除数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException();
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param bookingMasterItemVoucher
     * @return
     */
    @Override
    public BookingMasterItemVoucherDO create(CreateBookingMasterItemVoucherDTO bookingMasterItemVoucher) {
        throw new UnsupportedOperationException();
    }

    /**
     * 根据主键 存档数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean inactivate(Long id) {
        BookingMasterItemVoucherDO entity = detail(id);
        if (ObjectUtil.isEmpty(entity)) {
            throw new ServiceException(ResultCode.SC_NO_CONTENT);
        }
        //todo 判断状态是否正确
        entity.setStatus("xx");
        return changeStatus(entity);
    }

    /**
     * 根据主键 激活数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean activate(Long id) {
        BookingMasterItemVoucherDO entity = detail(id);
        if (ObjectUtil.isEmpty(entity)) {
            throw new ServiceException(ResultCode.SC_NO_CONTENT);
        }
        //todo 判断状态是否正确
        entity.setStatus("xx");
        return changeStatus(entity);
    }

}