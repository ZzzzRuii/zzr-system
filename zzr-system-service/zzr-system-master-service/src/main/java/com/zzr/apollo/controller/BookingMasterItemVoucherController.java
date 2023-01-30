package com.zzr.apollo.controller;

import com.zzr.apollo.api.R;
import com.zzr.apollo.master.dto.CreateBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterItemVoucherDTO;
import com.zzr.apollo.master.vo.BookingMasterItemVoucherVO;
import com.zzr.apollo.model.BookingMasterItemVoucherDO;
import com.zzr.apollo.service.IBookingMasterItemVoucherService;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;
import com.zzr.apollo.wrapper.BookingMasterItemVoucherWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 子订单 票号 控制器
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 14:39
 */
@RestController
@AllArgsConstructor
@Api(value = "子订单 票号")
@RequestMapping("/voucher")
public class BookingMasterItemVoucherController {

    private final IBookingMasterItemVoucherService bookingMasterItemVoucherService;


    /**
     * 查询!{entity} 根据条件
     *
     * @param query                    分页
     * @param bookingMasterItemVoucher
     */
    @GetMapping("/bookingMasterItemVouchers")
    @ApiOperation(value = "查询BookingMasterItemVoucher列表")
    public R<Page<BookingMasterItemVoucherVO>> selectPage(Query query, QueryBookingMasterItemVoucherDTO bookingMasterItemVoucher) {
        try {
            throw new UnsupportedOperationException();
        } catch (UnsupportedOperationException e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 创建对象BookingMasterItemVoucher
     *
     * @param bookingMasterItemVoucher
     */
    @PostMapping("/bookingMasterItemVouchers")
    @ApiOperation(value = "创建对象BookingMasterItemVoucher")
    public R<Long> create(@RequestBody CreateBookingMasterItemVoucherDTO bookingMasterItemVoucher) {
        try {
            throw new UnsupportedOperationException();
        } catch (UnsupportedOperationException e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 详情
     */
    @GetMapping("/bookingMasterItemVouchers/{id}")
    @ApiOperation(value = "根据Id获取BookingMasterItemVoucher详情")
    public R<BookingMasterItemVoucherVO> detail(@PathVariable("id") Long id) {
        try {
            BookingMasterItemVoucherDO entity = bookingMasterItemVoucherService.detail(id);
            BookingMasterItemVoucherVO vo = BookingMasterItemVoucherWrapper.build().entityVO(entity);
            return R.data(vo);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }


    /**
     * 根据Id 更新 BookingMasterItemVoucher对象
     *
     * @param id
     * @param bookingMasterItemVoucher
     */
    @PutMapping("/bookingMasterItemVoucher/{id}")
    @ApiOperation(value = "更新BookingMasterItemVoucher")
    public R<Long> update(@PathVariable("id") Long id, @RequestBody UpdateBookingMasterItemVoucherDTO bookingMasterItemVoucher) {
        try {
            throw new UnsupportedOperationException();
        } catch (UnsupportedOperationException e) {
            return R.fail(e.getMessage());
        }
    }


    /**
     * 根据id删除BookingMasterItemVoucher
     *
     * @param id 主键
     */
    @DeleteMapping("/bookingMasterItemVoucher/{id}")
    @ApiOperation(value = "删除BookingMasterItemVoucher")
    public R<String> delete(@PathVariable("id") Long id) {
        try {
            throw new UnsupportedOperationException();
        } catch (UnsupportedOperationException e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 根据id激活BookingMasterItemVoucher
     *
     * @param id 主键
     */
    @PutMapping("/bookingMasterItemVoucher/{id}/activate")
    @ApiOperation(value = "激活BookingMasterItemVoucher")
    public R<Boolean> activate(@PathVariable("id") Long id) {
        try {
            return R.data(bookingMasterItemVoucherService.activate(id));
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 根据id停用BookingMasterItemVoucher
     *
     * @param id 主键
     */
    @PutMapping("/bookingMasterItemVoucher/{id}/inactivate")
    @ApiOperation(value = "根据id停用BookingMasterItemVoucher")
    public R<Boolean> inactivate(@PathVariable("id") Long id) {
        try {
            return R.data(bookingMasterItemVoucherService.inactivate(id));
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

}
