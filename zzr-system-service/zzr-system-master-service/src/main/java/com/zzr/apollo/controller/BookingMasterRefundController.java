package com.zzr.apollo.controller;

import com.zzr.apollo.api.R;
import com.zzr.apollo.master.dto.CreateBookingMasterRefundDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterRefundDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterRefundDTO;
import com.zzr.apollo.master.vo.BookingMasterRefundVO;
import com.zzr.apollo.model.BookingMasterRefundDO;
import com.zzr.apollo.service.IBookingMasterRefundService;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;
import com.zzr.apollo.wrapper.BookingMasterRefundWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 主订单退款 控制器
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 14:40
 */
@RestController
@AllArgsConstructor
@Api(value = "主订单退款")
@RequestMapping("/refund")
public class BookingMasterRefundController {

    private final IBookingMasterRefundService bookingMasterRefundService;


    /**
     * 查询!{entity} 根据条件
     *
     * @param query     分页
     * @param refundDTO
     */
    @GetMapping
    @ApiOperation(value = "查询BookingMasterRefund列表")
    public R<Page<BookingMasterRefundVO>> selectPage(Query query, QueryBookingMasterRefundDTO refundDTO) {
        Page<BookingMasterRefundVO> bookingMasterRefundPage = bookingMasterRefundService.selectPage(query, refundDTO);

        return R.data(bookingMasterRefundPage);
    }

    /**
     * 创建对象BookingMasterRefund
     *
     * @param refundDTO
     * @return
     */
    @PostMapping
    @ApiOperation(value = "创建对象BookingMasterRefund")
    public R<Long> create(@RequestBody @Validated CreateBookingMasterRefundDTO refundDTO) {
        BookingMasterRefundDO bookingMasterRefundDO = bookingMasterRefundService.create(refundDTO);

        return R.data(bookingMasterRefundDO.getId());
    }

    /**
     * 详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取BookingMasterRefund详情")
    public R<BookingMasterRefundVO> detail(@PathVariable("id") Long id) {
        BookingMasterRefundDO bookingMasterRefundDO = bookingMasterRefundService.detail(id);
        BookingMasterRefundVO refundVO = BookingMasterRefundWrapper.build().entityVO(bookingMasterRefundDO);

        return R.data(refundVO);
    }


    /**
     * 根据Id 更新 BookingMasterRefund对象
     *
     * @param id
     * @param refundDTO
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新BookingMasterRefund")
    public R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateBookingMasterRefundDTO refundDTO) {
        Boolean result = bookingMasterRefundService.update(refundDTO, id);

        return R.data(result);
    }


    /**
     * 根据id删除BookingMasterRefund
     *
     * @param id 主键
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除BookingMasterRefund")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        Boolean result = bookingMasterRefundService.deleteById(id);

        return R.data(result);
    }

    /**
     * 根据id更改BookingMasterRefund状态
     *
     * @param id 主键
     */
    @PutMapping("/{id}/{status}")
    @ApiOperation(value = "根据id停用BookingMasterRefund")
    public R<Boolean> status(@PathVariable("id") Long id, @PathVariable("status") String status) {
        return R.data(bookingMasterRefundService.status(id, status));
    }

}

