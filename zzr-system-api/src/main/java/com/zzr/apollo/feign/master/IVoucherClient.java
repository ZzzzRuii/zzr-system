package com.zzr.apollo.feign.master;

import com.zzr.apollo.master.dto.CreateBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.vo.BookingMasterItemVoucherVO;
import com.zzr.base.api.R;
import com.zzr.base.constants.FeignConstants;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * IItemVoucherClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:01
 */
public interface IVoucherClient {
    /**
     * 查询
     *
     * @param query
     * @param dto
     * @return
     */
    @GetMapping(FeignConstants.MASTER_VOUCHER)
    R<Page<BookingMasterItemVoucherVO>> selectPage(@SpringQueryMap Query query, @SpringQueryMap QueryBookingMasterItemVoucherDTO dto);

    /**
     * 创建
     *
     * @param dto
     * @return
     */
    @PostMapping(FeignConstants.MASTER_VOUCHER)
    R<Long> create(@RequestBody CreateBookingMasterItemVoucherDTO dto);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(FeignConstants.MASTER_VOUCHER + "/{id}")
    R<BookingMasterItemVoucherVO> detail(@PathVariable("id") Long id);

    /**
     * 更新
     *
     * @param id
     * @param dto
     * @return
     */
    @PutMapping(FeignConstants.MASTER_VOUCHER + "/{id}")
    R<Long> update(@PathVariable("id") Long id, @RequestBody UpdateBookingMasterItemVoucherDTO dto);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(FeignConstants.MASTER_VOUCHER + "/{id}")
    R<String> delete(@PathVariable("id") Long id);

    /**
     * 激活
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER_VOUCHER + "/{id}/activate")
    R<Boolean> activate(@PathVariable("id") Long id);

    /**
     * 停用
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER_VOUCHER + "/{id}/inactivate")
    R<Boolean> inactivate(@PathVariable("id") Long id);
}
