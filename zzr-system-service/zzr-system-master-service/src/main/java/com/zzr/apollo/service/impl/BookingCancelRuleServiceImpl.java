package com.zzr.apollo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.nacos.shaded.com.google.common.base.Preconditions;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.api.ResultCode;
import com.zzr.apollo.mapper.BookingCancelRuleMapper;
import com.zzr.apollo.master.dto.CreateBookingCancelRuleDTO;
import com.zzr.apollo.master.dto.CreateBookingItemCancelRuleDTO;
import com.zzr.apollo.master.dto.QueryBookingCancelRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingCancelRuleDTO;
import com.zzr.apollo.master.vo.BookingCancelRuleVO;
import com.zzr.apollo.master.vo.BookingMasterItemVO;
import com.zzr.apollo.model.BookingCancelRuleDO;
import com.zzr.apollo.product.vo.ProductTicketVO;
import com.zzr.apollo.service.*;
import com.zzr.apollo.support.Condition;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;
import com.zzr.apollo.tool.constants.DemoResultCode;
import com.zzr.apollo.tool.constants.DemoStatusCode;
import com.zzr.apollo.tool.constants.MasterStatusCode;
import com.zzr.apollo.wrapper.BookingCancelRuleWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 退改规则 服务实现类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:19
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BookingCancelRuleServiceImpl extends ZzrServiceImpl<BookingCancelRuleMapper, BookingCancelRuleDO> implements IBookingCancelRuleService {

    private final IProductTicketService productService;

    private final IBookingMasterItemService itemService;

    private final IBookingMasterService masterService;

    private final IBookingItemCancelRuleService itemCancelRuleService;

    @Override
    public BookingCancelRuleDO detail(Long id) {
        return baseMapper.selectById(id);
    }

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param bookingCancelRule
     * @return
     */
    @Override
    public Page<BookingCancelRuleVO> selectPage(Query query, QueryBookingCancelRuleDTO bookingCancelRule) {
        IPage<BookingCancelRuleDO> page = Condition.getPage(query);
        page.setRecords(baseMapper.selectCancelPage(page, bookingCancelRule));

        return BookingCancelRuleWrapper.build().pageVO(page);
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param bookingCancelRule
     * @return
     */
    @Override
    public BookingCancelRuleDO create(CreateBookingCancelRuleDTO bookingCancelRule) {
        BookingCancelRuleDO ruleDO = BookingCancelRuleWrapper.build().voEntity(bookingCancelRule);

        // 组织信息
        BookingCancelRuleDO unit = baseMapper.selectByUnitId(ruleDO.getUnitId());
        Preconditions.checkNotNull(unit, DemoResultCode.UNIT_NOT_EXISTS.getMessage());
        ruleDO.setTenantId(unit.getTenantId());
        ruleDO.setUnitType(unit.getUnitType());

        // 产品信息
        ProductTicketVO productVO = productService.selectByCode(ruleDO.getCode());
        ruleDO.setName(productVO.getName());

        // 是否受支持，默认true
        ruleDO.setIsObsolete(true);

        save(ruleDO);

        // 激活
        activate(ruleDO.getId());

        // 调用子订单取消
        List<BookingMasterItemVO> voList = itemService.selectByOrderId(bookingCancelRule.getOrderId());
        for (BookingMasterItemVO item : voList) {
            if (!ObjectUtil.equals(item.getStatus(), MasterStatusCode.CANCELED.getCode())) {
                CreateBookingItemCancelRuleDTO ruleDTO = new CreateBookingItemCancelRuleDTO();
                BeanUtil.copyProperties(ruleDO, ruleDTO);
                ruleDTO.setItemId(item.getId());
                itemCancelRuleService.create(ruleDTO);
            }
        }

        // 更新主订单状态
        masterService.canceled(bookingCancelRule.getOrderId());

        return ruleDO;
    }

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param bookingCancelRule
     * @param id
     * @return
     */
    @Override
    public Boolean update(UpdateBookingCancelRuleDTO bookingCancelRule, Long id) {
        BookingCancelRuleDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        BookingCancelRuleDO ruleDO = BookingCancelRuleWrapper.build().voEntity(bookingCancelRule);
        ruleDO.setId(id);

        return updateById(ruleDO);
    }


    /***
     *   根据主键 删除数据
     *   查询不到数据 ServiceException 异常
     *   @param id
     *  @return
     */
    @Override
    public Boolean deleteById(Long id) {
        BookingCancelRuleDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        return baseMapper.deleteById(id) != 0;
    }

    /***
     *   根据主键 存档数据
     *   查询不到数据 ServiceException 异常
     *   @param id
     *  @return
     */
    @Override
    public Boolean inactivate(Long id) {
        BookingCancelRuleDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        entity.setStatus(DemoStatusCode.INACTIVE.getCode());
        return changeStatus(entity);
    }

    /***
     *   根据主键 激活数据
     *   查询不到数据 ServiceException 异常
     *   @param id
     *  @return
     */
    @Override
    public Boolean activate(Long id) {
        BookingCancelRuleDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        entity.setStatus(DemoStatusCode.ACTIVATE.getCode());
        return changeStatus(entity);
    }

}
