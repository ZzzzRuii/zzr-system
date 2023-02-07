package com.zzr.apollo.feign.channel;

import com.zzr.apollo.channel.dto.CreateCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.dto.QueryCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.dto.UpdateCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.vo.CmmProductDailyAmountVO;
import com.zzr.base.api.R;
import com.zzr.base.constants.FeignConstants;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ProductDailyAmountClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/6 18:01
 */
public interface IProductDailyAmountClient {
    /**
     * 查询每日库存 根据条件
     *
     * @param query 分页
     * @param dto
     * @return
     */
    @GetMapping(FeignConstants.CHANNEL_PRODUCT_DAILY_AMOUNT)
    R<Page<CmmProductDailyAmountVO>> selectPage(@SpringQueryMap Query query, @SpringQueryMap QueryCmmProductDailyAmountDTO dto);

    /**
     * 创建对象每日库存
     *
     * @param dto
     * @return 主订单id
     */
    @PostMapping(FeignConstants.CHANNEL_PRODUCT_DAILY_AMOUNT)
    R<List<Long>> create(@RequestBody CreateCmmProductDailyAmountDTO dto);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(FeignConstants.CHANNEL_PRODUCT_DAILY_AMOUNT + "/{id}")
    R<CmmProductDailyAmountVO> detail(@PathVariable("id") Long id);

    /**
     * 根据Id 更新 每日库存 对象
     *
     * @param id
     * @param dto
     * @return
     */
    @PutMapping(FeignConstants.CHANNEL_PRODUCT_DAILY_AMOUNT + "/{id}")
    R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateCmmProductDailyAmountDTO dto);

    /**
     * 根据id删除 每日库存
     *
     * @param id 主键
     * @return
     */
    @DeleteMapping(FeignConstants.CHANNEL_PRODUCT_DAILY_AMOUNT + "/{id}")
    R<Boolean> delete(@PathVariable("id") Long id);

    /**
     * 根据id激活 每日库存
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.CHANNEL_PRODUCT_DAILY_AMOUNT + "/{id}/activate")
    R<Boolean> activate(@PathVariable("id") Long id);

    /**
     * 根据id停用 每日库存
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.CHANNEL_PRODUCT_DAILY_AMOUNT + "/{id}/inactivate")
    R<Boolean> inactive(@PathVariable("id") Long id);
}
