package com.zzr.apollo.feign.channel;

import com.zzr.apollo.channel.dto.CreateCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.dto.QueryCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.dto.UpdateCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.vo.CmmProductDailyChannelRateVO;
import com.zzr.base.api.R;
import com.zzr.base.constants.FeignConstants;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * IProductDailyRateClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 10:19
 */
public interface IProductDailyRateClient {
    /**
     * 查询每日价格 根据条件
     *
     * @param query 分页
     * @param dto
     * @return
     */
    @GetMapping(FeignConstants.CHANNEL_PRODUCT_DAILY_RATE)
    R<Page<CmmProductDailyChannelRateVO>> selectPage(@SpringQueryMap Query query, @SpringQueryMap QueryCmmProductDailyChannelRateDTO dto);

    /**
     * 创建每日价格对象
     *
     * @param dto
     * @return 主订单id
     */
    @PostMapping(FeignConstants.CHANNEL_PRODUCT_DAILY_RATE)
    R<List<Long>> create(@RequestBody CreateCmmProductDailyChannelRateDTO dto);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(FeignConstants.CHANNEL_PRODUCT_DAILY_RATE + "/{id}")
    R<CmmProductDailyChannelRateVO> detail(@PathVariable("id") Long id);

    /**
     * 根据Id 更新 每日价格 对象
     *
     * @param id
     * @param dto
     * @return
     */
    @PutMapping(FeignConstants.CHANNEL_PRODUCT_DAILY_RATE + "/{id}")
    R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateCmmProductDailyChannelRateDTO dto);

    /**
     * 根据id删除 每日价格
     *
     * @param id 主键
     * @return
     */
    @DeleteMapping(FeignConstants.CHANNEL_PRODUCT_DAILY_RATE + "/{id}")
    R<Boolean> delete(@PathVariable("id") Long id);

    /**
     * 根据id激活 每日价格
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.CHANNEL_PRODUCT_DAILY_RATE + "/{id}/activate")
    R<Boolean> activate(@PathVariable("id") Long id);

    /**
     * 根据id停用 每日价格
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.CHANNEL_PRODUCT_DAILY_RATE + "/{id}/inactivate")
    R<Boolean> inactivate(@PathVariable("id") Long id);
}
