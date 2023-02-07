package com.zzr.apollo.feign.master;

import com.zzr.apollo.master.dto.CreateBookingMasterRefundItemDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterRefundItemDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterRefundItemDTO;
import com.zzr.apollo.master.vo.BookingMasterRefundItemVO;
import com.zzr.base.api.R;
import com.zzr.base.constants.FeignConstants;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * IRefundItemClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:02
 */
public interface IRefundItemClient {
    /**
     * 查询
     *
     * @param query
     * @param dto
     * @return
     */
    @GetMapping(FeignConstants.MASTER_REFUND_ITEM)
    R<Page<BookingMasterRefundItemVO>> selectPage(@SpringQueryMap Query query, @SpringQueryMap QueryBookingMasterRefundItemDTO dto);

    /**
     * 创建
     *
     * @param dto
     * @return
     */
    @PostMapping(FeignConstants.MASTER_REFUND_ITEM)
    R<Long> create(@RequestBody CreateBookingMasterRefundItemDTO dto);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(FeignConstants.MASTER_REFUND_ITEM + "/{id}")
    R<BookingMasterRefundItemVO> detail(@PathVariable("id") Long id);

    /**
     * 更新
     *
     * @param id
     * @param dto
     * @return
     */
    @PutMapping(FeignConstants.MASTER_REFUND_ITEM + "/{id}")
    R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateBookingMasterRefundItemDTO dto);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(FeignConstants.MASTER_REFUND_ITEM + "/{id}")
    R<Boolean> delete(@PathVariable("id") Long id);

    /**
     * 更改状态
     *
     * @param id
     * @param status
     * @return
     */
    @PutMapping(FeignConstants.MASTER_REFUND_ITEM + "/{id}/{status}")
    R<Boolean> status(@PathVariable("id") Long id, @PathVariable("status") String status);
}
