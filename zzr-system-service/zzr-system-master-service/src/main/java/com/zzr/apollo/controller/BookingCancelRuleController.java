package com.zzr.apollo.controller;

import com.zzr.apollo.master.dto.CreateBookingCancelRuleDTO;
import com.zzr.apollo.master.dto.QueryBookingCancelRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingCancelRuleDTO;
import com.zzr.apollo.master.vo.BookingCancelRuleVO;
import com.zzr.apollo.model.BookingCancelRuleDO;
import com.zzr.apollo.service.IBookingCancelRuleService;
import com.zzr.apollo.wrapper.BookingCancelRuleWrapper;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 退改规则 控制器
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 14:06
 */
@RestController
@AllArgsConstructor
@Api(value = "退改规则")
@RequestMapping("/cancel")
public class BookingCancelRuleController {

    private final IBookingCancelRuleService bookingCancelRuleService;


    /**
     * 查询!{entity} 根据条件
     *
     * @param query             分页
     * @param bookingCancelRule
     */
    @GetMapping
    @ApiOperation(value = "查询BookingCancelRule列表")
    public R<Page<BookingCancelRuleVO>> selectPage(Query query, QueryBookingCancelRuleDTO bookingCancelRule) {
        Page<BookingCancelRuleVO> voPage = bookingCancelRuleService.selectPage(query, bookingCancelRule);

        return R.data(voPage);
    }

    /**
     * 创建对象BookingCancelRule
     *
     * @param bookingCancelRule
     */
    @PostMapping
    @ApiOperation(value = "创建对象BookingCancelRule")
    public R<Long> create(@RequestBody @Validated CreateBookingCancelRuleDTO bookingCancelRule) {
        BookingCancelRuleDO bookingCancelRuleDO = bookingCancelRuleService.create(bookingCancelRule);

        return R.data(bookingCancelRuleDO.getId());
    }

    /**
     * 详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取BookingCancelRule详情")
    public R<BookingCancelRuleVO> detail(@PathVariable("id") Long id) {
        BookingCancelRuleDO entity = bookingCancelRuleService.detail(id);
        BookingCancelRuleVO vo = BookingCancelRuleWrapper.build().entityVO(entity);
        return R.data(vo);
    }


    /**
     * 根据Id 更新 BookingCancelRule对象
     *
     * @param id
     * @param bookingCancelRule
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新BookingCancelRule")
    public R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateBookingCancelRuleDTO bookingCancelRule) {
        Boolean result = bookingCancelRuleService.update(bookingCancelRule, id);

        return R.data(result);
    }


    /**
     * 根据id删除BookingCancelRule
     *
     * @param id 主键
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除BookingCancelRule")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        Boolean result = bookingCancelRuleService.deleteById(id);

        return R.data(result);
    }

    /**
     * 根据id激活BookingCancelRule
     *
     * @param id 主键
     */
    @PutMapping("/{id}/activate")
    @ApiOperation(value = "激活BookingCancelRule")
    public R<Boolean> activate(@PathVariable("id") Long id) {
        return R.data(bookingCancelRuleService.activate(id));
    }

    /**
     * 根据id停用BookingCancelRule
     *
     * @param id 主键
     */
    @PutMapping("/{id}/inactivate")
    @ApiOperation(value = "根据id停用BookingCancelRule")
    public R<Boolean> inactivate(@PathVariable("id") Long id) {
        return R.data(bookingCancelRuleService.inactivate(id));
    }

}
