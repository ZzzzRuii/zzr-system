package com.zzr.apollo.feign.master;

import com.zzr.apollo.master.dto.CreateBookingMasterItemDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterItemDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterItemDTO;
import com.zzr.apollo.master.vo.BookingMasterItemVO;
import com.zzr.base.api.R;
import com.zzr.base.constants.FeignConstants;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * IMasterItemClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 13:01
 */
public interface IMasterItemClient {
    /**
     * 查询
     *
     * @param query
     * @param dto
     * @return
     */
    @GetMapping(FeignConstants.MASTER_ITEM)
    R<Page<BookingMasterItemVO>> selectPage(@SpringQueryMap Query query, @SpringQueryMap QueryBookingMasterItemDTO dto);

    /**
     * 创建
     *
     * @param dto
     * @return 子订单id
     */
    @PostMapping(FeignConstants.MASTER_ITEM)
    R<Long> create(@RequestBody CreateBookingMasterItemDTO dto);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(FeignConstants.MASTER_ITEM + "/{id}")
    R<BookingMasterItemVO> detail(@PathVariable("id") Long id);

    /**
     * 更新
     *
     * @param id
     * @param dto
     * @return
     */
    @PutMapping(FeignConstants.MASTER_ITEM + "/{id}")
    R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateBookingMasterItemDTO dto);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(FeignConstants.MASTER_ITEM + "/{id}")
    R<Boolean> delete(@PathVariable("id") Long id);

    /**
     * 根据主键 预付款
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.MASTER_ITEM + "/{id}/reserve")
    R<Boolean> reserve(@PathVariable("id") Long id);

    /**
     * 根据主键 已付款
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.MASTER_ITEM + "/{id}/rePay")
    R<Boolean> rePay(@PathVariable("id") Long id);

    /**
     * 根据主键 已取消
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER_ITEM + "/{id}/canceled")
    R<Boolean> canceled(@PathVariable("id") Long id);

    /**
     * 根据主键 确认中
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER_ITEM + "/{id}/confirming")
    R<Boolean> confirming(@PathVariable("id") Long id);

    /**
     * 根据主键 已确认
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER_ITEM + "/{id}/confirmed")
    R<Boolean> confirmed(@PathVariable("id") Long id);

    /**
     * 根据主键 执行中
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER_ITEM + "/{id}/doing")
    R<Boolean> doing(@PathVariable("id") Long id);

    /**
     * 根据主键 完成
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.MASTER_ITEM + "/{id}/complete")
    R<Boolean> complete(@PathVariable("id") Long id);
}
