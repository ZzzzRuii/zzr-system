package com.zzr.apollo.controller;

import com.zzr.apollo.api.R;
import com.zzr.apollo.model.ProductTicketDO;
import com.zzr.apollo.product.dto.CreateProductTicketDTO;
import com.zzr.apollo.product.dto.QueryProductTicketDTO;
import com.zzr.apollo.product.dto.UpdateProductTicketDTO;
import com.zzr.apollo.product.vo.ProductTicketVO;
import com.zzr.apollo.service.IProductTicketService;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;
import com.zzr.apollo.wrapper.ProductTicketWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 产品控制器
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/10 13:06
 */
@RestController
@AllArgsConstructor
@Api(value = "产品")
@RequestMapping("/product")
public class ProductTicketController {

    private final IProductTicketService productService;

    /**
     * 查询!{entity} 根据条件
     *
     * @param query      分页
     * @param productDTO
     */
    @GetMapping
    @ApiOperation(value = "查询ProductTicket列表")
    public R<Page<ProductTicketVO>> selectPage(Query query, QueryProductTicketDTO productDTO) {
        return R.data(productService.selectPage(query, productDTO));
    }

    /**
     * 创建对象 ProductTicket
     *
     * @param productDTO
     * @return 主订单id
     */
    @PostMapping
    @ApiOperation(value = "创建对象ProductTicket")
    public R<Long> create(@RequestBody @Valid CreateProductTicketDTO productDTO) {
        ProductTicketDO productDO = productService.create(productDTO);

        return R.data(productDO.getId());
    }

    /**
     * 详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取ProductTicket详情")
    public R<ProductTicketVO> detail(@PathVariable("id") Long id) {
        ProductTicketDO entity = productService.detail(id);
        ProductTicketVO vo = ProductTicketWrapper.build().entityVO(entity);

        return R.data(vo);
    }


    /**
     * 根据Id 更新 ProductTicket 对象
     *
     * @param id
     * @param productDTO
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新ProductTicket")
    public R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateProductTicketDTO productDTO) {
        return R.data(productService.update(productDTO, id));
    }


    /**
     * 根据id删除 ProductTicket
     *
     * @param id 主键
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除ProductTicket")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        return R.data(productService.deleteById(id));
    }

    /**
     * 根据id激活 ProductTicket
     *
     * @param id 主键
     */
    @PutMapping("/{id}/activate")
    @ApiOperation(value = "激活ProductTicket")
    public R<Boolean> activate(@PathVariable("id") Long id) {
        return R.data(productService.activate(id));
    }

    /**
     * 根据id停用 ProductTicket
     *
     * @param id 主键
     */
    @PutMapping("/{id}/inactivate")
    @ApiOperation(value = "根据id停用ProductTicket")
    public R<Boolean> inactive(@PathVariable("id") Long id) {
        return R.data(productService.inactive(id));
    }

    /**
     * 产品库存控制
     *
     * @param id
     * @param model
     * @return
     */
    @PutMapping("/{id}/changeModel")
    @ApiOperation(value = "根据id更改ProductTicket库存模式")
    public R<Boolean> changeModel(@PathVariable("id") Long id, @RequestParam("model") String model) {
        return R.data(productService.changeModel(id, model));
    }

}
