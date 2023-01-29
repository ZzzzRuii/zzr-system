package com.zzr.apollo.controller;

import com.zzr.apollo.api.R;
import com.zzr.apollo.master.dto.CreateBookingMasterItemDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterItemDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterItemDTO;
import com.zzr.apollo.master.vo.BookingMasterItemVO;
import com.zzr.apollo.model.BookingMasterItemDO;
import com.zzr.apollo.service.IBookingMasterItemService;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;
import com.zzr.apollo.wrapper.BookingMasterItemWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 子订单 控制器
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 14:38
 */
@RestController
@AllArgsConstructor
@Api(value = "子订单")
@RequestMapping("/master/item")
public class BookingMasterItemController {

    private final IBookingMasterItemService bookingMasterItemService;

    /**
     * 查询!{entity} 根据条件
     *
     * @param query             分页
     * @param bookingMasterItem
     */
    @GetMapping
    @ApiOperation(value = "查询BookingMasterItem列表")
    public R<Page<BookingMasterItemVO>> selectPage(Query query, QueryBookingMasterItemDTO bookingMasterItem) {
        Page<BookingMasterItemVO> bookingMasterItemPage = bookingMasterItemService.selectPage(query, bookingMasterItem);

        return R.data(bookingMasterItemPage);
    }

    /**
     * 创建对象BookingMasterItem
     *
     * @param bookingMasterItem
     * @return 子订单id
     */
    @PostMapping
    @ApiOperation(value = "创建对象BookingMasterItem")
    public R<Long> create(@RequestBody @Validated CreateBookingMasterItemDTO bookingMasterItem) {
        BookingMasterItemDO bookingMasterItemDO = bookingMasterItemService.create(bookingMasterItem);

        return R.data(bookingMasterItemDO.getId());
    }

    /**
     * 详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取BookingMasterItem详情")
    public R<BookingMasterItemVO> detail(@PathVariable("id") Long id) {
        BookingMasterItemDO entity = bookingMasterItemService.detail(id);
        BookingMasterItemVO vo = BookingMasterItemWrapper.build().entityVO(entity);

        return R.data(vo);
    }


    /**
     * 根据Id 更新 BookingMasterItem对象
     *
     * @param id
     * @param bookingMasterItem
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新BookingMasterItem")
    public R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateBookingMasterItemDTO bookingMasterItem) {

        return R.data(bookingMasterItemService.update(bookingMasterItem, id));
    }


    /**
     * 根据id删除BookingMasterItem
     *
     * @param id 主键
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除BookingMasterItem")
    public R<Boolean> delete(@PathVariable("id") Long id) {

        return R.data(bookingMasterItemService.deleteById(id));
    }

    /**
     * 根据主键 预付款
     *
     * @param id 主键
     */
    @PutMapping("/{id}/reserve")
    @ApiOperation(value = "预付款BookingMaster")
    public R<Boolean> reserve(@PathVariable("id") Long id) {
        return R.data(bookingMasterItemService.reserve(id));
    }

    /**
     * 根据主键 已付款
     *
     * @param id 主键
     */
    @PutMapping("/{id}/rePay")
    @ApiOperation(value = "已付款BookingMaster")
    public R<Boolean> rePay(@PathVariable("id") Long id) {
        return R.data(bookingMasterItemService.rePay(id));
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
        return R.data(bookingMasterItemService.canceled(id));
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
        return R.data(bookingMasterItemService.confirming(id));
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
        return R.data(bookingMasterItemService.confirmed(id));
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
        return R.data(bookingMasterItemService.doing(id));
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
        return R.data(bookingMasterItemService.complete(id));
    }

}
