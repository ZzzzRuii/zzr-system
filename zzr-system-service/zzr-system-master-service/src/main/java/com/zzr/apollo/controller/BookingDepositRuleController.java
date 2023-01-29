package com.zzr.apollo.controller;

import com.zzr.apollo.master.dto.CreateBookingDepositRuleDTO;
import com.zzr.apollo.master.dto.QueryBookingDepositRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingDepositRuleDTO;
import com.zzr.apollo.master.vo.BookingDepositRuleVO;
import com.zzr.apollo.model.BookingDepositRuleDO;
import com.zzr.apollo.service.IBookingDepositRuleService;
import com.zzr.apollo.wrapper.BookingDepositRuleWrapper;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 担保规则 控制器
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 14:34
 */
@RestController
@AllArgsConstructor
@Api(value = "担保规则")
@RequestMapping("/deposit")
public class BookingDepositRuleController {

    private final IBookingDepositRuleService bookingDepositRuleService;

    /**
     * 查询!{entity} 根据条件
     *
     * @param query              分页
     * @param bookingDepositRule
     */
    @GetMapping
    @ApiOperation(value = "查询BookingDepositRule列表")
    public R<Page<BookingDepositRuleVO>> selectPage(Query query, QueryBookingDepositRuleDTO bookingDepositRule) {
        Page<BookingDepositRuleVO> voPage = bookingDepositRuleService.selectPage(query, bookingDepositRule);
        return R.data(voPage);
    }

    /**
     * 创建对象BookingDepositRule
     *
     * @param bookingDepositRule
     */
    @PostMapping
    @ApiOperation(value = "创建对象BookingDepositRule")
    public R<Long> create(@RequestBody CreateBookingDepositRuleDTO bookingDepositRule) {
        BookingDepositRuleDO ruleDO = bookingDepositRuleService.create(bookingDepositRule);

        return R.data(ruleDO.getId());
    }

    /**
     * 详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取BookingDepositRule详情")
    public R<BookingDepositRuleVO> detail(@PathVariable("id") Long id) {
        BookingDepositRuleDO entity = bookingDepositRuleService.detail(id);
        BookingDepositRuleVO vo = BookingDepositRuleWrapper.build().entityVO(entity);
        return R.data(vo);
    }


    /**
     * 根据Id 更新 BookingDepositRule对象
     *
     * @param id
     * @param bookingDepositRule
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新BookingDepositRule")
    public R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateBookingDepositRuleDTO bookingDepositRule) {
        Boolean result = bookingDepositRuleService.update(bookingDepositRule, id);

        return R.data(result);
    }


    /**
     * 根据id删除BookingDepositRule
     *
     * @param id 主键
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除BookingDepositRule")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        Boolean result = bookingDepositRuleService.deleteById(id);

        return R.data(result);
    }

    /**
     * 根据id激活BookingDepositRule
     *
     * @param id 主键
     */
    @PutMapping("/{id}/activate")
    @ApiOperation(value = "激活BookingDepositRule")
    public R<Boolean> activate(@PathVariable("id") Long id) {
        return R.data(bookingDepositRuleService.activate(id));
    }

    /**
     * 根据id停用BookingDepositRule
     *
     * @param id 主键
     */
    @PutMapping("/{id}/inactivate")
    @ApiOperation(value = "根据id停用BookingDepositRule")
    public R<Boolean> inactivate(@PathVariable("id") Long id) {
        return R.data(bookingDepositRuleService.inactivate(id));
    }

}
