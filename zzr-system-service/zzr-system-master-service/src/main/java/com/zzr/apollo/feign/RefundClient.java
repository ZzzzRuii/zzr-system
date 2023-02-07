package com.zzr.apollo.feign;

import com.zzr.apollo.feign.master.IRefundClient;
import com.zzr.apollo.master.dto.CreateBookingMasterRefundDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterRefundDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterRefundDTO;
import com.zzr.apollo.master.vo.BookingMasterRefundVO;
import com.zzr.apollo.service.IBookingMasterRefundService;
import com.zzr.apollo.wrapper.BookingMasterRefundWrapper;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * RefundClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 15:01
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class RefundClient implements IRefundClient {

    private final IBookingMasterRefundService service;


    /**
     * 查询
     *
     * @param query
     * @param dto
     * @return
     */
    @Override
    public R<Page<BookingMasterRefundVO>> selectPage(Query query, QueryBookingMasterRefundDTO dto) {
        return R.data(service.selectPage(query, dto));
    }

    /**
     * 创建
     *
     * @param dto
     * @return
     */
    @Override
    public R<Long> create(CreateBookingMasterRefundDTO dto) {
        return R.data(service.create(dto).getId());
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public R<BookingMasterRefundVO> detail(Long id) {
        return R.data(BookingMasterRefundWrapper.build().entityVO(service.detail(id)));
    }

    /**
     * 更新
     *
     * @param id
     * @param dto
     * @return
     */
    @Override
    public R<Boolean> update(Long id, UpdateBookingMasterRefundDTO dto) {
        return R.data(service.update(dto, id));
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public R<Boolean> delete(Long id) {
        return R.data(service.deleteById(id));
    }

    /**
     * 状态更改
     *
     * @param id
     * @param status
     * @return
     */
    @Override
    public R<Boolean> status(Long id, String status) {
        return R.data(service.status(id, status));
    }
}
