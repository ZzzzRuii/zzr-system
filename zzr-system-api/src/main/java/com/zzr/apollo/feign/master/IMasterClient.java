package com.zzr.apollo.feign.master;

import com.zzr.apollo.master.dto.CreateBookingMasterDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterDTO;
import com.zzr.apollo.master.vo.BookingMasterVO;
import com.zzr.base.api.R;
import com.zzr.base.constants.FeignConstants;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * IMasterClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:00
 */
public interface IMasterClient {
    /**
     * 查询
     *
     * @param query
     * @param dto
     * @return
     */
    @GetMapping(FeignConstants.MASTER)
    R<Page<BookingMasterVO>> selectPage(@SpringQueryMap Query query, @SpringQueryMap QueryBookingMasterDTO dto);

    /**
     * 创建
     *
     * @param dto
     * @return 主订单id
     */
    @PostMapping(FeignConstants.MASTER)
    R<Long> create(@RequestBody CreateBookingMasterDTO dto);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(FeignConstants.MASTER + "/{id}")
    R<BookingMasterVO> detail(@PathVariable("id") Long id);

    /**
     * 更新
     *
     * @param id
     * @param dto
     * @return
     */
    @PutMapping(FeignConstants.MASTER + "/{id}")
    R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateBookingMasterDTO dto);

    /**
     * 根据id删除BookingMaster
     *
     * @param id 主键
     * @return
     */
    @DeleteMapping(FeignConstants.MASTER + "/{id}")
    R<Boolean> delete(@PathVariable("id") Long id);

    /**
     * 根据主键 预付款
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.MASTER + "/{id}/reserve")
    R<Boolean> reserve(@PathVariable("id") Long id);

    /**
     * 根据主键 已付款
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.MASTER + "/{id}/rePay")
    @ApiOperation(value = "已付款BookingMaster")
    R<Boolean> rePay(@PathVariable("id") Long id);

    /**
     * 根据主键 已取消
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER + "/{id}/canceled")
    R<Boolean> canceled(@PathVariable("id") Long id);

    /**
     * 根据主键 确认中
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER + "/{id}/confirming")
    R<Boolean> confirming(@PathVariable("id") Long id);

    /**
     * 根据主键 已确认
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER + "/{id}/confirmed")
    R<Boolean> confirmed(@PathVariable("id") Long id);

    /**
     * 根据主键 执行中
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER + "/{id}/doing")
    R<Boolean> doing(@PathVariable("id") Long id);

    /**
     * 根据主键 完成
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER + "/{id}/complete")
    R<Boolean> complete(@PathVariable("id") Long id);
}
