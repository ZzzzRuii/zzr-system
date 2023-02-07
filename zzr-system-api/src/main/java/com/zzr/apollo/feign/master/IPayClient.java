package com.zzr.apollo.feign.master;

import com.zzr.apollo.master.dto.CreateBookingMasterPayDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterPayDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterPayDTO;
import com.zzr.apollo.master.vo.BookingMasterPayVO;
import com.zzr.base.api.R;
import com.zzr.base.constants.FeignConstants;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * IPayClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:01
 */
public interface IPayClient {
    /**
     * 查询
     *
     * @param query
     * @param dto
     * @return
     */
    @GetMapping(FeignConstants.MASTER_PAY)
    R<Page<BookingMasterPayVO>> selectPage(@SpringQueryMap Query query, @SpringQueryMap QueryBookingMasterPayDTO dto);

    /**
     * 创建
     *
     * @param dto
     * @return
     */
    @PostMapping(FeignConstants.MASTER_PAY)
    R<Long> create(@RequestBody CreateBookingMasterPayDTO dto);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(FeignConstants.MASTER_PAY + "/{id}")
    R<BookingMasterPayVO> detail(@PathVariable("id") Long id);

    /**
     * 更新
     *
     * @param id
     * @param dto
     * @return
     */
    @PutMapping(FeignConstants.MASTER_PAY + "/{id}")
    R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateBookingMasterPayDTO dto);


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(FeignConstants.MASTER_PAY + "/{id}")
    R<Boolean> delete(@PathVariable("id") Long id);

    /**
     * 激活
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER_PAY + "{id}/activate")
    R<Boolean> activate(@PathVariable("id") Long id);

    /**
     * 停用
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER_PAY + "/{id}/inactivate")
    R<Boolean> inactivate(@PathVariable("id") Long id);
}
