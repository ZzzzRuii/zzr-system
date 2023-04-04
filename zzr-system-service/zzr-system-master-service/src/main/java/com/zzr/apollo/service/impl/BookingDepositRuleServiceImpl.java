package com.zzr.apollo.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.nacos.shaded.com.google.common.base.Preconditions;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.mapper.BookingDepositRuleMapper;
import com.zzr.apollo.master.dto.CreateBookingCancelRuleDTO;
import com.zzr.apollo.master.dto.CreateBookingDepositRuleDTO;
import com.zzr.apollo.master.dto.QueryBookingDepositRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingDepositRuleDTO;
import com.zzr.apollo.master.vo.BookingDepositRuleVO;
import com.zzr.apollo.model.BookingDepositRuleDO;
import com.zzr.apollo.product.vo.ProductTicketVO;
import com.zzr.apollo.service.IBookingCancelRuleService;
import com.zzr.apollo.service.IBookingDepositRuleService;
import com.zzr.apollo.service.IProductTicketService;
import com.zzr.apollo.tool.constants.DemoResultCode;
import com.zzr.apollo.tool.constants.DemoStatusCode;
import com.zzr.apollo.wrapper.BookingDepositRuleWrapper;
import com.zzr.base.api.ResultCode;
import com.zzr.base.service.impl.ZzrServiceImpl;
import com.zzr.base.support.Condition;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 担保规则 服务实现类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:27
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BookingDepositRuleServiceImpl extends ZzrServiceImpl<BookingDepositRuleMapper, BookingDepositRuleDO> implements IBookingDepositRuleService {

    private final IProductTicketService productService;

    private final IBookingCancelRuleService cancelRuleService;

    @Override
    public BookingDepositRuleDO detail(Long id) {
        return baseMapper.selectById(id);
    }

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param bookingDepositRule
     * @return
     */
    @Override
    public Page<BookingDepositRuleVO> selectPage(Query query, QueryBookingDepositRuleDTO bookingDepositRule) {
        IPage<BookingDepositRuleDO> page = Condition.getPage(query);
        page.setRecords(baseMapper.selectDepositRulePage(page, bookingDepositRule));

        return BookingDepositRuleWrapper.build().pageVO(page);
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param bookingDepositRule
     * @return
     */
    @Override
    public BookingDepositRuleDO create(CreateBookingDepositRuleDTO bookingDepositRule) {
        BookingDepositRuleDO ruleDO = BookingDepositRuleWrapper.build().voEntity(bookingDepositRule);
        // 组织信息
        BookingDepositRuleDO unit = baseMapper.selectByUnitId(ruleDO.getUnitId());
        Preconditions.checkNotNull(unit, DemoResultCode.UNIT_NOT_EXISTS.getMessage());
        ruleDO.setTenantId(unit.getTenantId());
        ruleDO.setUnitType(unit.getUnitType());
        // 产品信息
        ProductTicketVO productVO = productService.selectByCode(ruleDO.getCode());
        ruleDO.setName(productVO.getName());
        // 自动执行取消
        autoCancel(ruleDO);
        // 创建
        save(ruleDO);
        // 激活
        activate(ruleDO.getId());
        return ruleDO;
    }

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param bookingDepositRule
     * @param id
     * @return
     */
    @Override
    public Boolean update(UpdateBookingDepositRuleDTO bookingDepositRule, Long id) {
        BookingDepositRuleDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        BookingDepositRuleDO ruleDO = BookingDepositRuleWrapper.build().voEntity(bookingDepositRule);
        ruleDO.setId(id);
        // 自动执行取消
        autoCancel(ruleDO);

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
        BookingDepositRuleDO entity = detail(id);
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
        BookingDepositRuleDO entity = detail(id);
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
        BookingDepositRuleDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        entity.setStatus(DemoStatusCode.ACTIVATE.getCode());
        return changeStatus(entity);
    }


    /**
     * 使用定时器判断什么时候自动执行取消
     *
     * @param ruleDO
     */
    private void autoCancel(BookingDepositRuleDO ruleDO) {
        Integer time;
        if (ObjectUtil.isNotNull(ruleDO.getDueDays())) {
            if (ObjectUtil.isNotNull(ruleDO.getResMinute())) {
                time = ruleDO.getResMinute();
            } else {
                time = ruleDO.getDueDays() * 1440;
            }
            ThreadUtil.newExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    ThreadUtil.sleep(time, TimeUnit.MINUTES);
                    CreateBookingCancelRuleDTO cancelRuleDTO = new CreateBookingCancelRuleDTO();
                    BeanUtils.copyProperties(ruleDO, cancelRuleDTO);
                    cancelRuleDTO.setType("canclx");
                    cancelRuleService.create(cancelRuleDTO);
                }
            });
        }
    }

}