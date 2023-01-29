package com.zzr.apollo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.nacos.shaded.com.google.common.base.Preconditions;
import com.alibaba.nacos.shaded.com.google.gson.Gson;
import com.alibaba.nacos.shaded.com.google.gson.reflect.TypeToken;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.api.ResultCode;
import com.zzr.apollo.event.ProductCreateEvent;
import com.zzr.apollo.event.ProductDeleteEvent;
import com.zzr.apollo.event.ProductUpdateEvent;
import com.zzr.apollo.mapper.ProductTicketMapper;
import com.zzr.apollo.model.ProductTicketDO;
import com.zzr.apollo.product.dto.CreateProductTicketDTO;
import com.zzr.apollo.product.dto.QueryProductTicketDTO;
import com.zzr.apollo.product.dto.UpdateProductTicketDTO;
import com.zzr.apollo.product.vo.ProductTicketVO;
import com.zzr.apollo.service.IProductTicketService;
import com.zzr.apollo.support.Condition;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;
import com.zzr.apollo.tool.constants.DemoResultCode;
import com.zzr.apollo.tool.constants.DemoStatusCode;
import com.zzr.apollo.wrapper.ProductTicketWrapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ProductTicketServiceImpl
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/9 18:04
 */
@Service
public class ProductTicketServiceImpl extends ZzrServiceImpl<ProductTicketMapper, ProductTicketDO> implements IProductTicketService {

    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    @Override
    public ProductTicketDO detail(Long id) {
        return baseMapper.selectById(id);
    }

    /**
     * 根据 unit_id 查询数据
     *
     * @param unitId
     * @return
     */
    @Override
    public List<ProductTicketVO> selectByUnitId(Long unitId) {
        QueryProductTicketDTO dto = new QueryProductTicketDTO();
        dto.setUnitId(unitId);
        List<ProductTicketDO> doList = selectList(dto);

        List<ProductTicketVO> voList = CollUtil.newArrayList();
        doList.forEach(item -> {
            voList.add(ProductTicketWrapper.build().entityVO(item));
        });

        return voList;
    }

    /**
     * 根据 code 查询数据
     *
     * @param code
     * @return
     */
    @Override
    public ProductTicketVO selectByCode(String code) {
        QueryProductTicketDTO queryDTO = new QueryProductTicketDTO();
        queryDTO.setCode(code);
        List<ProductTicketDO> paramList = selectList(queryDTO);

        Preconditions.checkArgument(CollUtil.isNotEmpty(paramList), DemoResultCode.PRODUCT_NOT_EXISTS.getMessage());

        return ProductTicketWrapper.build().entityVO(paramList.get(0));
    }

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param productDTO
     * @return
     */
    @Override
    public Page<ProductTicketVO> selectPage(Query query, QueryProductTicketDTO productDTO) {
        IPage<ProductTicketDO> page = Condition.getPage(query);
        page.setRecords(baseMapper.selectProductPage(page, productDTO));

        return ProductTicketWrapper.build().pageVO(page);
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param productDTO
     * @return
     */
    @Override
    public ProductTicketDO create(CreateProductTicketDTO productDTO) {

        ProductTicketDO productDO = ProductTicketWrapper.build().dtoEntity(productDTO);
        save(paramCheck(productDO));

        productCreatePublisher(productDO);

        return productDO;
    }

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param productDTO
     * @param id
     * @return
     */
    @Override
    public Boolean update(UpdateProductTicketDTO productDTO, Long id) {
        // 检查数据是否存在
        ProductTicketDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        ProductTicketDO productDO = ProductTicketWrapper.build().dtoEntity(productDTO);
        productDO.setId(id);

        boolean result = updateById(productDO);
        ProductTicketDO updateProductDO = detail(id);

        productUpdatePublisher(updateProductDO);

        return result;
    }

    /**
     * 根据主键 删除数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean deleteById(Long id) {
        // 检查数据是否存在
        ProductTicketDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        productDeletePublisher(entity);

        return baseMapper.deleteById(id) != 0;
    }

    /**
     * 根据主键 未激活
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean inactive(Long id) {
        ProductTicketDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());
        // 判断状态是否正确
        if (StrUtil.equals(DemoStatusCode.ACTIVATE.getCode(), entity.getStatus())) {
            entity.setStatus(DemoStatusCode.INACTIVE.getCode());
        }
        productUpdatePublisher(entity);
        return changeStatus(entity);
    }

    /**
     * 根据主键 激活
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean activate(Long id) {
        ProductTicketDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());
        // 判断状态是否正确
        if (StrUtil.equals(DemoStatusCode.INACTIVE.getCode(), entity.getStatus())) {
            entity.setStatus(DemoStatusCode.ACTIVATE.getCode());
        }
        productUpdatePublisher(entity);
        return changeStatus(entity);
    }

    /**
     * 根据 ID 更新 库存模式
     *
     * @param id
     * @param model
     * @return
     */
    @Override
    public Boolean changeModel(Long id, String model) {
        ProductTicketDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());
        entity.setStockMode(model);

        // 同时发送消息给 库存表，进行模式更新
        productUpdatePublisher(entity);

        return updateById(entity);
    }


    /**
     * 根据参数 查询数据
     * 列表
     *
     * @param productDTO
     * @return
     */
    private List<ProductTicketDO> selectList(QueryProductTicketDTO productDTO) {
        return baseMapper.selectProductList(productDTO);
    }

    /**
     * 根据参数 查询数据
     * 判断参数是否唯一
     *
     * @param code
     * @return
     */
    private Boolean codeUniqueness(String code) {
        ProductTicketVO vo = selectByCode(code);

        return ObjectUtil.isNull(vo);
    }

    /**
     * 根据参数 查询数据
     * 判断参数是否唯一
     *
     * @param name
     * @return
     */
    private Boolean nameUniqueness(String name) {
        QueryProductTicketDTO queryDTO = new QueryProductTicketDTO();
        queryDTO.setName(name);
        List<ProductTicketDO> paramList = selectList(queryDTO);

        return ObjectUtil.isEmpty(paramList);
    }

    /**
     * 检查参数是否唯一 是否存在
     *
     * @param productDO
     * @return
     */
    private ProductTicketDO paramCheck(ProductTicketDO productDO) {

        // 检查 code 唯一
        Preconditions.checkArgument(codeUniqueness(productDO.getCode()), DemoResultCode.DATA_ALREADY_EXIST.getMessage());

        // 检查 name 唯一
        Preconditions.checkArgument(nameUniqueness(productDO.getName()), DemoResultCode.DATA_ALREADY_EXIST.getMessage());

        // 产品创建时判断渠道是否存在，不存在返回 数据不存在 异常
        List<Long> idList = baseMapper.selectInCmmChannel();
        // 去除空对象
        idList = idList.stream().filter(ObjectUtil::isNotNull).collect(Collectors.toList());
        boolean channelFlag = false;
        for (Long item : idList) {
            if (NumberUtil.equals(item, productDO.getChannelId())) {
                channelFlag = true;
                break;
            }
        }
        Preconditions.checkArgument(channelFlag, ResultCode.SC_NO_CONTENT.getMessage());

        // 产品创建时判断发行单位是否存在，不存在返回 数据不存在 异常，存在直接填入发行单位类型
        List<ProductTicketDO> unitDO = baseMapper.selectInSystemUnitChainInfo();
        boolean unitFlag = false;
        for (ProductTicketDO item : unitDO) {
            if (NumberUtil.equals(item.getUnitId(), productDO.getUnitId())) {
                productDO.setUnitType(item.getUnitType());
                productDO.setTenantId(item.getTenantId());
                unitFlag = true;
                break;
            }
        }
        Preconditions.checkArgument(unitFlag, ResultCode.SC_NO_CONTENT.getMessage());

        return productDO;
    }


    /**
     * 产品创建消息发布
     *
     * @param entity
     */
    private void productCreatePublisher(ProductTicketDO entity) {
        Gson gson = new Gson();
        HashMap<String, String> productMap = gson.fromJson(gson.toJson(entity), new TypeToken<HashMap<String, String>>() {
        }.getType());
        ProductCreateEvent event = new ProductCreateEvent(this, productMap);
        SpringUtil.publishEvent(event);
    }

    /**
     * 产品更新消息发布
     *
     * @param entity
     */
    private void productUpdatePublisher(ProductTicketDO entity) {
        Gson gson = new Gson();
        HashMap<String, String> productMap = gson.fromJson(gson.toJson(entity), new TypeToken<HashMap<String, String>>() {
        }.getType());
        ProductUpdateEvent event = new ProductUpdateEvent(this, productMap);

        SpringUtil.publishEvent(event);
    }

    /**
     * 产品删除消息发布
     *
     * @param entity
     */
    private void productDeletePublisher(ProductTicketDO entity) {
        Gson gson = new Gson();
        HashMap<String, String> productMap = gson.fromJson(gson.toJson(entity), new TypeToken<HashMap<String, String>>() {
        }.getType());
        ProductDeleteEvent event = new ProductDeleteEvent(this, productMap);
        SpringUtil.publishEvent(event);
    }

}
