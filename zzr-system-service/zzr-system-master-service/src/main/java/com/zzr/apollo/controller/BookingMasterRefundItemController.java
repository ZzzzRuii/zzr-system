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
        try {
            Page<BookingMasterRefundItemVO> bookingMasterRefundItemPage = bookingMasterRefundItemService.selectPage(query, refundItemDTO);

            return R.data(bookingMasterRefundItemPage);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
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
        try {
            BookingMasterRefundItemDO bookingMasterRefundItemDO = bookingMasterRefundItemService.create(refundItemDTO);

            return R.data(bookingMasterRefundItemDO.getId());
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取BookingMasterRefundItem详情")
    public R<BookingMasterRefundItemVO> detail(@PathVariable("id") Long id) {
        try {
            BookingMasterRefundItemDO bookingMasterRefundItemDO = bookingMasterRefundItemService.detail(id);
            BookingMasterRefundItemVO refundItemVO = BookingMasterRefundItemWrapper.build().entityVO(bookingMasterRefundItemDO);

            return R.data(refundItemVO);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
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
        try {
            Boolean result = bookingMasterRefundItemService.update(refundItemDTO, id);

            return R.data(result);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }


    /**
     * 根据id删除BookingMasterRefundItem
     *
     * @param id 主键
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除BookingMasterRefundItem")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        try {
            Boolean result = bookingMasterRefundItemService.deleteById(id);

            return R.data(result);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }


    /**
     * 根据id更改BookingMasterRefund状态
     *
     * @param id 主键
     */
    @PutMapping("/{id}/{status}")
    @ApiOperation(value = "根据id停用BookingMasterRefund")
    public R<Boolean> status(@PathVariable("id") Long id, @PathVariable("status") String status) {
        try {
            return R.data(bookingMasterRefundItemService.status(id, status));
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

}

