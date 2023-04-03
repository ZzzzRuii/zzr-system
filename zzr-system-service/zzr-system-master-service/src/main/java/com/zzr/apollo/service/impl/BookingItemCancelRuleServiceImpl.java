package com.zzr.apollo.service.impl;

import com.alibaba.nacos.shaded.com.google.common.base.Preconditions;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.mapper.BookingItemCancelRuleMapper;
import com.zzr.apollo.master.dto.CreateBookingItemCancelRuleDTO;
import com.zzr.apollo.master.dto.QueryBookingItemCancelRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingItemCancelRuleDTO;
import com.zzr.apollo.master.vo.BookingItemCancelRuleVO;
import com.zzr.apollo.model.BookingItemCancelRuleDO;
import com.zzr.apollo.product.vo.ProductTicketVO;
import com.zzr.apollo.service.IBookingItemCancelRuleService;
import com.zzr.apollo.service.IProductTicketService;
import com.zzr.apollo.tool.constants.DemoStatusCode;
import com.zzr.apollo.wrapper.BookingItemCancelRuleWrapper;
import com.zzr.base.api.ResultCode;
import com.zzr.base.service.impl.ZzrServiceImpl;
import com.zzr.base.support.Condition;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 取消规则服务实现类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:34
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BookingItemCancelRuleServiceImpl extends ZzrServiceImpl<BookingItemCancelRuleMapper, BookingItemCancelRuleDO> implements IBookingItemCancelRuleService {

    private final IProductTicketService productService;

    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    @Override
    public BookingItemCancelRuleDO detail(Long id) {
        return baseMapper.selectById(id);
    }

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param itemCancelRuleDTO
     * @return
     */
    @Override
    public Page<BookingItemCancelRuleVO> selectPage(Query query, QueryBookingItemCancelRuleDTO itemCancelRuleDTO) {
        IPage<BookingItemCancelRuleDO> page = Condition.getPage(query);
        page.setRecords(baseMapper.selectItemCancelRulePage(page, itemCancelRuleDTO));

        return BookingItemCancelRuleWrapper.build().pageVO(page);
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param itemCancelRuleDTO
     * @return
     */
    @Override
    public BookingItemCancelRuleDO create(CreateBookingItemCancelRuleDTO itemCancelRuleDTO) {
        BookingItemCancelRuleDO ruleDO = BookingItemCancelRuleWrapper.build().dtoEntity(itemCancelRuleDTO);

        // 产品信息
        ProductTicketVO productVO = productService.selectByCode(ruleDO.getCode());
        ruleDO.setName(productVO.getName());

        // 创建取消规则
        save(ruleDO);

        // 激活
        activate(ruleDO.getId());

        return ruleDO;
    }

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param itemCancelRuleDTO
     * @param id
     * @return
     */
    @Override
    public Boolean update(UpdateBookingItemCancelRuleDTO itemCancelRuleDTO, Long id) {
        BookingItemCancelRuleDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        BookingItemCancelRuleDO ruleDO = BookingItemCancelRuleWrapper.build().dtoEntity(itemCancelRuleDTO);
        ruleDO.setId(id);
        return updateById(ruleDO);
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
        BookingItemCancelRuleDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        return baseMapper.deleteById(id) != 0;
    }


    /**
     * 根据主键 存档数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean inactivate(Long id) {
        BookingItemCancelRuleDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        entity.setStatus(DemoStatusCode.INACTIVE.getCode());
        return changeStatus(entity);
    }

    /**
     * 根据主键 激活数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean activate(Long id) {
        BookingItemCancelRuleDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        entity.setStatus(DemoStatusCode.ACTIVATE.getCode());
        return changeStatus(entity);
    }
}
