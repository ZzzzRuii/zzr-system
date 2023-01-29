package com.zzr.apollo.controller;

import com.zzr.apollo.api.R;
import com.zzr.apollo.channel.dto.CreateCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.dto.QueryCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.dto.UpdateCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.vo.CmmProductDailyChannelRateVO;
import com.zzr.apollo.model.CmmProductDailyChannelRateDO;
import com.zzr.apollo.service.ICmmProductDailyChannelRateService;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;
import com.zzr.apollo.wrapper.CmmProductDailyChannelRateWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 每日价格控制类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/28 11:02
 */
@RestController
@AllArgsConstructor
@Api(value = "价格")
@RequestMapping("/rate")
public class CmmProductDailyChannelRateController {

    private final ICmmProductDailyChannelRateService rateService;

    /**
     * 查询!{entity} 根据条件
     *
     * @param query   分页
     * @param rateDTO
     */
    @GetMapping
    @ApiOperation(value = "查询CmmProductDailyChannelRate列表")
    public R<Page<CmmProductDailyChannelRateVO>> selectPage(Query query, QueryCmmProductDailyChannelRateDTO rateDTO) {
        return R.data(rateService.selectPage(query, rateDTO));
    }

    /**
     * 创建对象CmmProductDailyChannelRate
     *
     * @param rateDTO
     * @return 主订单id
     */
    @PostMapping
    @ApiOperation(value = "创建对象CmmProductDailyChannelRate")
    public R<List<Long>> create(@RequestBody @Valid CreateCmmProductDailyChannelRateDTO rateDTO) {
        try {
            return R.data(rateService.create(rateDTO));
        } catch (Exception exception) {
            return R.fail(exception.getMessage());
        }
    }

    /**
     * 详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取CmmProductDailyChannelRate详情")
    public R<CmmProductDailyChannelRateVO> detail(@PathVariable("id") Long id) {
        CmmProductDailyChannelRateDO entity = rateService.detail(id);
        CmmProductDailyChannelRateVO vo = CmmProductDailyChannelRateWrapper.build().entityVO(entity);

        return R.data(vo);
    }

    /**
     * 根据Id 更新 CmmProductDailyChannelRate 对象
     *
     * @param id
     * @param rateDTO
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新CmmProductDailyChannelRate")
    public R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateCmmProductDailyChannelRateDTO rateDTO) {
        try {
            return R.data(rateService.update(rateDTO, id));
        } catch (Exception exception) {
            return R.fail(exception.getMessage());
        }
    }

    /**
     * 根据id删除 CmmProductDailyChannelRate
     *
     * @param id 主键
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除CmmProductDailyChannelRate")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        try {
            return R.data(rateService.deleteById(id));
        } catch (Exception exception) {
            return R.fail(exception.getMessage());
        }
    }

    /**
     * 根据id激活 CmmProductDailyChannelRate
     *
     * @param id 主键
     */
    @PutMapping("/{id}/activate")
    @ApiOperation(value = "激活CmmProductDailyChannelRate")
    public R<Boolean> activate(@PathVariable("id") Long id) {
        try {
            return R.data(rateService.activate(id));
        } catch (Exception exception) {
            return R.fail(exception.getMessage());
        }
    }

    /**
     * 根据id停用 CmmProductDailyChannelRate
     *
     * @param id 主键
     */
    @PutMapping("/{id}/inactivate")
    @ApiOperation(value = "根据id停用CmmProductDailyChannelRate")
    public R<Boolean> inactive(@PathVariable("id") Long id) {
        try {
            return R.data(rateService.inactive(id));
        } catch (Exception exception) {
            return R.fail(exception.getMessage());
        }
    }

}
