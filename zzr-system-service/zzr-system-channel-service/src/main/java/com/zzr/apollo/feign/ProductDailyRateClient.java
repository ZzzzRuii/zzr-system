package com.zzr.apollo.feign;

import com.zzr.apollo.channel.dto.CreateCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.dto.QueryCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.dto.UpdateCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.vo.CmmProductDailyChannelRateVO;
import com.zzr.apollo.feign.channel.IProductDailyRateClient;
import com.zzr.apollo.service.ICmmProductDailyChannelRateService;
import com.zzr.apollo.wrapper.CmmProductDailyChannelRateWrapper;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ProductDailyRateClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 10:26
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductDailyRateClient implements IProductDailyRateClient {

    private final ICmmProductDailyChannelRateService service;


    /**
     * 查询每日价格 根据条件
     *
     * @param query 分页
     * @param dto
     * @return
     */
    @Override
    public R<Page<CmmProductDailyChannelRateVO>> selectPage(Query query, QueryCmmProductDailyChannelRateDTO dto) {
        return R.data(service.selectPage(query, dto));
    }

    /**
     * 创建每日价格对象
     *
     * @param dto
     * @return 主订单id
     */
    @Override
    public R<List<Long>> create(CreateCmmProductDailyChannelRateDTO dto) {
        return R.data(service.create(dto));
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public R<CmmProductDailyChannelRateVO> detail(Long id) {
        return R.data(CmmProductDailyChannelRateWrapper.build().entityVO(service.detail(id)));
    }

    /**
     * 根据Id 更新 每日价格 对象
     *
     * @param id
     * @param dto
     * @return
     */
    @Override
    public R<Boolean> update(Long id, UpdateCmmProductDailyChannelRateDTO dto) {
        return R.data(service.update(dto, id));
    }

    /**
     * 根据id删除 每日价格
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> delete(Long id) {
        return R.data(service.deleteById(id));
    }

    /**
     * 根据id激活 每日价格
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> activate(Long id) {
        return R.data(service.activate(id));
    }

    /**
     * 根据id停用 每日价格
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> inactivate(Long id) {
        return R.data(service.inactive(id));
    }
}
