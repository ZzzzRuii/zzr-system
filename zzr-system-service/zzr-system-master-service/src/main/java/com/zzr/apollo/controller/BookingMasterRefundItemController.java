package com.zzr.apollo.controller;

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 子订单退款 控制器
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 14:41
 */
@RestController
@AllArgsConstructor
@Api(value = "子订单退款")
@RequestMapping("/refund/item")
public class BookingMasterRefundItemController {

    private final IBookingMasterRefundItemService bookingMasterRefundItemService;


    /**
     * 查询!{entity} 根据条件
     *
     * @param query         分页
     * @param refundItemDTO
     */
    @GetMapping
    @ApiOperation(value = "查询BookingMasterRefundItem列表")
    public R<Page<BookingMasterRefundItemVO>> selectPage(Query query, QueryBookingMasterRefundItemDTO refundItemDTO) {
        Page<BookingMasterRefundItemVO> bookingMasterRefundItemPage = bookingMasterRefundItemService.selectPage(query, refundItemDTO);

        return R.data(bookingMasterRefundItemPage);
    }

    /**
     * 创建对象BookingMasterRefundItem
     *
     * @param refundItemDTO
     * @return
     */
    @PostMapping
    @ApiOperation(value = "创建对象BookingMasterRefundItem")
    public R<Long> create(@RequestBody @Validated CreateBookingMasterRefundItemDTO refundItemDTO) {
        BookingMasterRefundItemDO bookingMasterRefundItemDO = bookingMasterRefundItemService.create(refundItemDTO);

        return R.data(bookingMasterRefundItemDO.getId());
    }

    /**
     * 详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取BookingMasterRefundItem详情")
    public R<BookingMasterRefundItemVO> detail(@PathVariable("id") Long id) {
        BookingMasterRefundItemDO bookingMasterRefundItemDO = bookingMasterRefundItemService.detail(id);
        BookingMasterRefundItemVO refundItemVO = BookingMasterRefundItemWrapper.build().entityVO(bookingMasterRefundItemDO);

        return R.data(refundItemVO);
    }


    /**
     * 根据Id 更新 BookingMasterRefundItem对象
     *
     * @param id
     * @param refundItemDTO
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新BookingMasterRefundItem")
    public R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateBookingMasterRefundItemDTO refundItemDTO) {
        Boolean result = bookingMasterRefundItemService.update(refundItemDTO, id);

        return R.data(result);
    }


    /**
     * 根据id删除BookingMasterRefundItem
     *
     * @param id 主键
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除BookingMasterRefundItem")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        Boolean result = bookingMasterRefundItemService.deleteById(id);

        return R.data(result);
    }


    /**
     * 根据主键 预付款
     *
     * @param id 主键
     */
    @PutMapping("/{id}/reserve")
    @ApiOperation(value = "预付款BookingMaster")
    public R<Boolean> reserve(@PathVariable("id") Long id) {
        return R.data(bookingMasterRefundItemService.reserve(id));
    }

    /**
     * 根据主键 已付款
     *
     * @param id 主键
     */
    @PutMapping("/{id}/rePay")
    @ApiOperation(value = "已付款BookingMaster")
    public R<Boolean> rePay(@PathVariable("id") Long id) {
        return R.data(bookingMasterRefundItemService.rePay(id));
    }

    /**
     * 根据主键 已取消
     *
     * @param id
     * @return
     */
    @PutMapping("/{id}/canceled")
    @ApiOperation(value = "已取消BookingMaster")
    public R<Boolean> canceled(@PathVariable("id") Long id) {
        return R.data(bookingMasterRefundItemService.canceled(id));
    }

    /**
     * 根据主键 确认中
     *
     * @param id
     * @return
     */
    @PutMapping("/{id}/confirming")
    @ApiOperation(value = "确认中BookingMaster")
    public R<Boolean> confirming(@PathVariable("id") Long id) {
        return R.data(bookingMasterRefundItemService.confirming(id));
    }

    /**
     * 根据主键 已确认
     *
     * @param id
     * @return
     */
    @PutMapping("/{id}/confirmed")
    @ApiOperation(value = "已确认BookingMaster")
    public R<Boolean> confirmed(@PathVariable("id") Long id) {
        return R.data(bookingMasterRefundItemService.confirmed(id));
    }

    /**
     * 根据主键 执行中
     *
     * @param id
     * @return
     */
    @PutMapping("/{id}/doing")
    @ApiOperation(value = "执行中BookingMaster")
    public R<Boolean> doing(@PathVariable("id") Long id) {
        return R.data(bookingMasterRefundItemService.doing(id));
    }

    /**
     * 根据主键 完成
     *
     * @param id
     * @return
     */
    @PutMapping("/{id}/complete")
    @ApiOperation(value = "完成BookingMaster")
    public R<Boolean> complete(@PathVariable("id") Long id) {
        return R.data(bookingMasterRefundItemService.complete(id));
    }

}

