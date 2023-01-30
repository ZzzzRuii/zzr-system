package com.zzr.apollo.service;

import com.zzr.apollo.model.ProductTicketDO;
import com.zzr.apollo.product.dto.CreateProductTicketDTO;
import com.zzr.apollo.product.dto.QueryProductTicketDTO;
import com.zzr.apollo.product.dto.UpdateProductTicketDTO;
import com.zzr.apollo.product.vo.ProductTicketVO;
import com.zzr.base.service.IZzrService;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;

import java.util.List;

/**
 * 产品服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/9 18:03
 */
public interface IProductTicketService extends IZzrService<ProductTicketDO> {

    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    ProductTicketDO detail(Long id);

    /**
     * 根据 unit_id 查询数据
     *
     * @param unitId
     * @return
     */
    List<ProductTicketVO> selectByUnitId(Long unitId);

    /**
     * 根据 code 查询数据
     *
     * @param code
     * @return
     */
    ProductTicketVO selectByCode(String code);

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param productDTO
     * @return
     */
    Page<ProductTicketVO> selectPage(Query query, QueryProductTicketDTO productDTO);

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param productDTO
     * @return
     */
    ProductTicketDO create(CreateProductTicketDTO productDTO);

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param productDTO
     * @param id
     * @return
     */
    Boolean update(UpdateProductTicketDTO productDTO, Long id);


    /**
     * 根据主键 删除数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean deleteById(Long id);

    /**
     * 根据主键 未激活
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean inactive(Long id);

    /**
     * 根据主键 激活
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean activate(Long id);

    /**
     * 根据 ID 更新 库存模式
     *
     * @param id
     * @param model
     * @return
     */
    Boolean changeModel(Long id, String model);
}
