package com.zzr.apollo.feign.master;

import com.zzr.apollo.master.dto.CreateBookingMasterRefundDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterRefundDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterRefundDTO;
import com.zzr.apollo.master.vo.BookingMasterRefundVO;
import com.zzr.base.api.R;
import com.zzr.base.constants.FeignConstants;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * IRefundClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:02
 */
public interface IRefundClient {
    /**
     * 查询
     *
     * @param query
     * @param dto
     * @return
     */
    @GetMapping(FeignConstants.MASTER_REFUND)
    R<Page<BookingMasterRefundVO>> selectPage(@SpringQueryMap Query query, @SpringQueryMap QueryBookingMasterRefundDTO dto);

    /**
     * 创建
     *
     * @param dto
     * @return
     */
    @PostMapping(FeignConstants.MASTER_REFUND)
    R<Long> create(@RequestBody CreateBookingMasterRefundDTO dto);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(FeignConstants.MASTER_REFUND + "/{id}")
    R<BookingMasterRefundVO> detail(@PathVariable("id") Long id);

    /**
     * 更新
     *
     * @param id
     * @param dto
     * @return
     */
    @PutMapping(FeignConstants.MASTER_REFUND + "/{id}")
    R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateBookingMasterRefundDTO dto);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(FeignConstants.MASTER_REFUND + "/{id}")
    R<Boolean> delete(@PathVariable("id") Long id);

    /**
     * 状态更改
     *
     * @param id
     * @param status
     * @return
     */
    @PutMapping(FeignConstants.MASTER_REFUND + "/{id}/{status}")
    R<Boolean> status(@PathVariable("id") Long id, @PathVariable("status") String status);
}
