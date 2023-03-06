package com.zzr.apollo.feign;

import cn.hutool.core.util.ObjectUtil;
import com.zzr.apollo.feign.master.IRefundItemClient;
import com.zzr.apollo.master.dto.CreateBookingMasterRefundItemDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterRefundItemDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterRefundItemDTO;
import com.zzr.apollo.master.vo.BookingMasterRefundItemVO;
import com.zzr.apollo.model.BookingMasterRefundItemDO;
import com.zzr.apollo.service.IBookingMasterRefundItemService;
import com.zzr.apollo.wrapper.BookingMasterRefundItemWrapper;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * RefundItemClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 15:02
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class RefundItemClient implements IRefundItemClient {

    private final IBookingMasterRefundItemService service;


    /**
     * 查询
     *
     * @param query
     * @param dto
     * @return
     */
    @Override
    public R<Page<BookingMasterRefundItemVO>> selectPage(Query query, QueryBookingMasterRefundItemDTO dto) {
        return R.data(service.selectPage(query, dto));
    }

    /**
     * 创建
     *
     * @param dto
     * @return
     */
    @Override
    public R<Long> create(CreateBookingMasterRefundItemDTO dto) {
        BookingMasterRefundItemDO entity = service.create(dto);
        return R.data(ObjectUtil.isNotNull(entity) ? entity.getId() : null);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public R<BookingMasterRefundItemVO> detail(Long id) {
        return R.data(BookingMasterRefundItemWrapper.build().entityVO(service.detail(id)));
    }

    /**
     * 更新
     *
     * @param id
     * @param dto
     * @return
     */
    @Override
    public R<Boolean> update(Long id, UpdateBookingMasterRefundItemDTO dto) {
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
     * 更改状态
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
