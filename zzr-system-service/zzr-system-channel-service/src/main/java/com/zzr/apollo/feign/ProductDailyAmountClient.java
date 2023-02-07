package com.zzr.apollo.feign;

import com.zzr.apollo.channel.dto.CreateCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.dto.QueryCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.dto.UpdateCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.vo.CmmProductDailyAmountVO;
import com.zzr.apollo.feign.channel.IProductDailyAmountClient;
import com.zzr.apollo.service.ICmmProductDailyAmountService;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ProductDailyAmountClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 10:02
 */
@Slf4j
@RestController
@AllArgsConstructor
public class ProductDailyAmountClient implements IProductDailyAmountClient {

    private final ICmmProductDailyAmountService service;


    /**
     * 查询每日库存 根据条件
     *
     * @param query     分页
     * @param amountDTO
     * @return
     */
    @Override
    public R<Page<CmmProductDailyAmountVO>> selectPage(Query query, QueryCmmProductDailyAmountDTO amountDTO) {
        return null;
    }

    /**
     * 创建对象每日库存
     *
     * @param amountDTO
     * @return 主订单id
     */
    @Override
    public R<List<Long>> create(CreateCmmProductDailyAmountDTO amountDTO) {
        return null;
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public R<CmmProductDailyAmountVO> detail(Long id) {
        return null;
    }

    /**
     * 根据Id 更新 每日库存 对象
     *
     * @param id
     * @param amountDTO
     * @return
     */
    @Override
    public R<Boolean> update(Long id, UpdateCmmProductDailyAmountDTO amountDTO) {
        return null;
    }

    /**
     * 根据id删除 每日库存
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> delete(Long id) {
        return null;
    }

    /**
     * 根据id激活 每日库存
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> activate(Long id) {
        return null;
    }

    /**
     * 根据id停用 每日库存
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> inactive(Long id) {
        return null;
    }
}
