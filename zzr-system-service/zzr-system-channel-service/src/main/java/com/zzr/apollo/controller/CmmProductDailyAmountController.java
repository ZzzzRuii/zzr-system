package com.zzr.apollo.controller;

import com.zzr.apollo.channel.dto.CreateCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.dto.QueryCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.dto.UpdateCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.vo.CmmProductDailyAmountVO;
import com.zzr.apollo.model.CmmProductDailyAmountDO;
import com.zzr.apollo.service.ICmmProductDailyAmountService;
import com.zzr.apollo.wrapper.CmmProductDailyAmountWrapper;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 每日库存控制类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/28 11:01
 */
@RestController
@AllArgsConstructor
@Api(value = "库存")
@RequestMapping("/amount")
public class CmmProductDailyAmountController {

    private final ICmmProductDailyAmountService amountService;

    /**
     * 查询!{entity} 根据条件
     *
     * @param query     分页
     * @param amountDTO
     * @return
     */
    @GetMapping
    @ApiOperation(value = "查询CmmProductDailyAmount列表")
    public R<Page<CmmProductDailyAmountVO>> selectPage(Query query, QueryCmmProductDailyAmountDTO amountDTO) {
        try {
            return R.data(amountService.selectPage(query, amountDTO));
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 创建对象CmmProductDailyAmount
     *
     * @param amountDTO
     * @return 主订单id
     */
    @PostMapping
    @ApiOperation(value = "创建对象CmmProductDailyAmount")
    public R<List<Long>> create(@RequestBody @Validated CreateCmmProductDailyAmountDTO amountDTO) {
        try {
            return R.data(amountService.create(amountDTO));
        } catch (Exception exception) {
            return R.fail(exception.getMessage());
        }
    }

    /**
     * 详情
     *
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取CmmProductDailyAmount详情")
    public R<CmmProductDailyAmountVO> detail(@PathVariable("id") Long id) {
        try {
            CmmProductDailyAmountDO entity = amountService.detail(id);
            CmmProductDailyAmountVO vo = CmmProductDailyAmountWrapper.build().entityVO(entity);

            return R.data(vo);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 根据Id 更新 CmmProductDailyAmount 对象
     *
     * @param id
     * @param amountDTO
     * @return
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新CmmProductDailyAmount")
    public R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateCmmProductDailyAmountDTO amountDTO) {
        try {
            return R.data(amountService.update(amountDTO, id));
        } catch (Exception exception) {
            return R.fail(exception.getMessage());
        }
    }

    /**
     * 根据id删除 CmmProductDailyAmount
     *
     * @param id 主键
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除CmmProductDailyAmount")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        try {
            return R.data(amountService.deleteById(id));
        } catch (Exception exception) {
            return R.fail(exception.getMessage());
        }
    }

    /**
     * 根据id激活 CmmProductDailyAmount
     *
     * @param id 主键
     * @return
     */
    @PutMapping("/{id}/activate")
    @ApiOperation(value = "激活CmmProductDailyAmount")
    public R<Boolean> activate(@PathVariable("id") Long id) {
        try {
            return R.data(amountService.activate(id));
        } catch (Exception exception) {
            return R.fail(exception.getMessage());
        }
    }

    /**
     * 根据id停用 CmmProductDailyAmount
     *
     * @param id 主键
     * @return
     */
    @PutMapping("/{id}/inactivate")
    @ApiOperation(value = "根据id停用CmmProductDailyAmount")
    public R<Boolean> inactive(@PathVariable("id") Long id) {
        try {
            return R.data(amountService.inactive(id));
        } catch (Exception exception) {
            return R.fail(exception.getMessage());
        }
    }

}
