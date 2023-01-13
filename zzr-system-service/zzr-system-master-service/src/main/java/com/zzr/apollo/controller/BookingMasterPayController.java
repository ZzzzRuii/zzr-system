package com.zzr.apollo.controller;

import com.zzr.apollo.master.dto.CreateBookingMasterPayDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterPayDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterPayDTO;
import com.zzr.apollo.master.vo.BookingMasterPayVO;
import com.zzr.apollo.model.BookingMasterPayDO;
import com.zzr.apollo.service.IBookingMasterPayService;
import com.zzr.apollo.wrapper.BookingMasterPayWrapper;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 订单支付 控制器
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 14:39
 */
@RestController
@AllArgsConstructor
@Api(value = "订单支付")
@RequestMapping("/pay")
public class BookingMasterPayController {

    private final IBookingMasterPayService payService;

    /**
     * 查询!{entity} 根据条件
     *
     * @param query  分页
     * @param payDTO
     */
    @GetMapping
    @ApiOperation(value = "查询BookingMasterPay列表")
    public R<Page<BookingMasterPayVO>> selectPage(Query query, QueryBookingMasterPayDTO payDTO) {
        Page<BookingMasterPayVO> page = payService.selectPage(query, payDTO);

        return R.data(page);
    }

    /**
     * 创建对象BookingMasterPay
     *
     * @param payDTO
     */
    @PostMapping
    @ApiOperation(value = "创建对象BookingMasterPay")
    public R<Long> create(@RequestBody @Validated CreateBookingMasterPayDTO payDTO) {
        BookingMasterPayDO payDO = payService.create(payDTO);

        return R.data(payDO.getId());
    }

    /**
     * 详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取BookingMasterPay详情")
    public R<BookingMasterPayVO> detail(@PathVariable("id") Long id) {
        BookingMasterPayDO entity = payService.detail(id);
        BookingMasterPayVO vo = BookingMasterPayWrapper.build().entityVO(entity);
        return R.data(vo);
    }


    /**
     * 根据Id 更新 BookingMasterPay对象
     *
     * @param id
     * @param payDTO
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新BookingMasterPay")
    public R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateBookingMasterPayDTO payDTO) {
        Boolean result = payService.update(payDTO, id);
        return R.data(result);
    }


    /**
     * 根据id删除BookingMasterPay
     *
     * @param id 主键
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除BookingMasterPay")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        Boolean result = payService.deleteById(id);
        return R.data(result);
    }

    /**
     * 根据id激活BookingMasterPay
     *
     * @param id 主键
     */
    @PutMapping("{id}/activate")
    @ApiOperation(value = "激活BookingMasterPay")
    public R<Boolean> activate(@PathVariable("id") Long id) {
        return R.data(payService.activate(id));
    }

    /**
     * 根据id停用BookingMasterPay
     *
     * @param id 主键
     */
    @PutMapping("/{id}/inactivate")
    @ApiOperation(value = "根据id停用BookingMasterPay")
    public R<Boolean> inactivate(@PathVariable("id") Long id) {
        return R.data(payService.inactivate(id));
    }

}
