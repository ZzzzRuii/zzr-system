package com.zzr.apollo.feign;

import com.zzr.apollo.feign.product.IProductTicketClient;
import com.zzr.apollo.product.dto.CreateProductTicketDTO;
import com.zzr.apollo.product.dto.QueryProductTicketDTO;
import com.zzr.apollo.product.dto.UpdateProductTicketDTO;
import com.zzr.apollo.product.vo.ProductTicketVO;
import com.zzr.apollo.service.IProductTicketService;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductTicketClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 11:08
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductTicketClient implements IProductTicketClient {

    private final IProductTicketService service;


    /**
     * 查询产品 根据条件
     *
     * @param query      分页
     * @param productDTO
     * @return
     */
    @Override
    public R<Page<ProductTicketVO>> selectPage(Query query, QueryProductTicketDTO productDTO) {
        return null;
    }

    /**
     * 创建对象 产品
     *
     * @param productDTO
     * @return 主订单id
     */
    @Override
    public R<Long> create(CreateProductTicketDTO productDTO) {
        return null;
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public R<ProductTicketVO> detail(Long id) {
        return null;
    }

    /**
     * 根据Id 更新 产品 对象
     *
     * @param id
     * @param productDTO
     * @return
     */
    @Override
    public R<Boolean> update(Long id, UpdateProductTicketDTO productDTO) {
        return null;
    }

    /**
     * 根据id删除 ProductTicket
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> delete(Long id) {
        return null;
    }

    /**
     * 根据id激活 产品
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> activate(Long id) {
        return null;
    }

    /**
     * 根据id停用 产品
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> inactivate(Long id) {
        return null;
    }

    /**
     * 产品库存控制
     *
     * @param id
     * @param model
     * @return
     */
    @Override
    public R<Boolean> changeModel(Long id, String model) {
        return null;
    }
}
