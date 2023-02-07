package com.zzr.apollo.feign;

import com.zzr.apollo.feign.master.IVoucherClient;
import com.zzr.apollo.master.dto.CreateBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.vo.BookingMasterItemVoucherVO;
import com.zzr.apollo.service.IBookingMasterItemVoucherService;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * VoucherClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 15:00
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class VoucherClient implements IVoucherClient {

    private final IBookingMasterItemVoucherService service;


    /**
     * 查询
     *
     * @param query
     * @param dto
     * @return
     */
    @Override
    public R<Page<BookingMasterItemVoucherVO>> selectPage(Query query, QueryBookingMasterItemVoucherDTO dto) {
        return null;
    }

    /**
     * 创建
     *
     * @param dto
     * @return
     */
    @Override
    public R<Long> create(CreateBookingMasterItemVoucherDTO dto) {
        return null;
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public R<BookingMasterItemVoucherVO> detail(Long id) {
        return null;
    }

    /**
     * 更新
     *
     * @param id
     * @param dto
     * @return
     */
    @Override
    public R<Long> update(Long id, UpdateBookingMasterItemVoucherDTO dto) {
        return null;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public R<String> delete(Long id) {
        return null;
    }

    /**
     * 激活
     *
     * @param id
     * @return
     */
    @Override
    public R<Boolean> activate(Long id) {
        return null;
    }

    /**
     * 停用
     *
     * @param id
     * @return
     */
    @Override
    public R<Boolean> inactivate(Long id) {
        return null;
    }
}
