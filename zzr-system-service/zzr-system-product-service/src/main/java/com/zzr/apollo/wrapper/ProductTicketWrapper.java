package com.zzr.apollo.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.zzr.apollo.model.ProductTicketDO;
import com.zzr.apollo.product.dto.CreateProductTicketDTO;
import com.zzr.apollo.product.dto.UpdateProductTicketDTO;
import com.zzr.apollo.product.vo.ProductTicketVO;

import java.util.Objects;

/**
 * 产品包装类，返回视图层所需的字段
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/9 18:01
 */
public class ProductTicketWrapper extends BaseEntityWrapper<ProductTicketDO, ProductTicketVO> {

    public static ProductTicketWrapper build() {
        return new ProductTicketWrapper();
    }

    @Override
    public ProductTicketVO entityVO(ProductTicketDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, ProductTicketVO.class));
    }

    @Override
    public ProductTicketDO voEntity(ProductTicketVO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, ProductTicketDO.class));
    }

    public ProductTicketDO dtoEntity(CreateProductTicketDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, ProductTicketDO.class));
    }

    public ProductTicketDO dtoEntity(UpdateProductTicketDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, ProductTicketDO.class));
    }
}
