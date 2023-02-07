package com.zzr.apollo.feign.product;

import com.zzr.apollo.product.dto.CreateProductTicketDTO;
import com.zzr.apollo.product.dto.QueryProductTicketDTO;
import com.zzr.apollo.product.dto.UpdateProductTicketDTO;
import com.zzr.apollo.product.vo.ProductTicketVO;
import com.zzr.base.api.R;
import com.zzr.base.constants.FeignConstants;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * IProductTicketClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 11:03
 */
public interface IProductTicketClient {
    /**
     * 查询产品 根据条件
     *
     * @param query      分页
     * @param productDTO
     * @return
     */
    @GetMapping(FeignConstants.PRODUCT_TICKET)
    R<Page<ProductTicketVO>> selectPage(@SpringQueryMap Query query, @SpringQueryMap QueryProductTicketDTO productDTO);

    /**
     * 创建对象 产品
     *
     * @param productDTO
     * @return 主订单id
     */
    @PostMapping(FeignConstants.PRODUCT_TICKET)
    R<Long> create(@RequestBody CreateProductTicketDTO productDTO);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(FeignConstants.PRODUCT_TICKET + "/{id}")
    R<ProductTicketVO> detail(@PathVariable("id") Long id);

    /**
     * 根据Id 更新 产品 对象
     *
     * @param id
     * @param productDTO
     * @return
     */
    @PutMapping(FeignConstants.PRODUCT_TICKET + "/{id}")
    R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateProductTicketDTO productDTO);

    /**
     * 根据id删除 ProductTicket
     *
     * @param id 主键
     * @return
     */
    @DeleteMapping(FeignConstants.PRODUCT_TICKET + "/{id}")
    R<Boolean> delete(@PathVariable("id") Long id);

    /**
     * 根据id激活 产品
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.PRODUCT_TICKET + "/{id}/activate")
    R<Boolean> activate(@PathVariable("id") Long id);

    /**
     * 根据id停用 产品
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.PRODUCT_TICKET + "/{id}/inactivate")
    R<Boolean> inactivate(@PathVariable("id") Long id);

    /**
     * 产品库存控制
     *
     * @param id
     * @param model
     * @return
     */
    @PutMapping(FeignConstants.PRODUCT_TICKET + "/{id}/changeModel")
    R<Boolean> changeModel(@PathVariable("id") Long id, @RequestParam("model") String model);
}
