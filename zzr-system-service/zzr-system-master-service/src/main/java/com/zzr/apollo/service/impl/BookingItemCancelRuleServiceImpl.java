package com.zzr.apollo.service.impl;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.nacos.shaded.com.google.common.base.Preconditions;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.channel.dto.UpdateCmmProductDailyAmountDTO;
import com.zzr.apollo.mapper.BookingItemCancelRuleMapper;
import com.zzr.apollo.master.dto.CreateBookingItemCancelRuleDTO;
import com.zzr.apollo.master.dto.QueryBookingItemCancelRuleDTO;
import com.zzr.apollo.master.dto.UpdateBookingItemCancelRuleDTO;
import com.zzr.apollo.master.vo.BookingItemCancelRuleVO;
import com.zzr.apollo.master.vo.BookingMasterItemVO;
import com.zzr.apollo.model.BookingItemCancelRuleDO;
import com.zzr.apollo.model.BookingMasterDO;
import com.zzr.apollo.model.BookingMasterItemDO;
import com.zzr.apollo.model.CmmProductDailyAmountDO;
import com.zzr.apollo.product.vo.ProductTicketVO;
import com.zzr.apollo.service.*;
import com.zzr.apollo.tool.constants.CancelModeCode;
import com.zzr.apollo.tool.constants.DemoResultCode;
import com.zzr.apollo.tool.constants.DemoStatusCode;
import com.zzr.apollo.tool.constants.MasterStatusCode;
import com.zzr.apollo.wrapper.BookingItemCancelRuleWrapper;
import com.zzr.base.api.ResultCode;
import com.zzr.base.exception.ServiceException;
import com.zzr.base.service.impl.ZzrServiceImpl;
import com.zzr.base.support.Condition;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    private final IBookingMasterService masterService;

    private final IBookingMasterItemService itemService;

    private final ICmmProductDailyAmountService amountService;

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

        // 主订单总金额减去该子订单实际金额，子订单金额不改变
        BookingMasterItemDO itemDO = itemService.detail(itemCancelRuleDTO.getItemId());
        if (ObjectUtil.equals(itemDO.getStatus(), MasterStatusCode.CANCELED.getCode())) {
            throw new ServiceException(DemoResultCode.ORDER_CANNOT_BE_CANCELLED_REPEATEDLY);
        }
        BookingMasterDO masterDO = masterService.detail(itemDO.getOrderId());
        masterDO.setTotalFee(masterDO.getTotalFee().subtract(itemDO.getFinalFee()));
        // 手续费计算
        BigDecimal serviceCharge;
        switch (ruleDO.getMode()) {
            case CancelModeCode.PERCENTAGE:
                serviceCharge = itemDO.getFinalFee().multiply(ruleDO.getPercentage());
                break;
            case CancelModeCode.AMOUNT:
                serviceCharge = ruleDO.getAmount();
                break;
            case CancelModeCode.TOTAL:
                serviceCharge = itemDO.getFinalFee();
                break;
            default:
                throw new IllegalStateException(ResultCode.SC_NO_CONTENT.getMessage());
        }
        // 主订单更新总金额（加上手续费）
        masterDO.setTotalFee(masterDO.getTotalFee().add(serviceCharge));
        if (ObjectUtil.equals(masterDO.getTotalFee(), 0)) {
            masterDO.setFinalFee(masterDO.getTotalFee());
        } else {
            masterDO.setFinalFee(masterDO.getTotalFee().subtract(masterDO.getDiscountFee()));
        }
        masterDO.setQuantity(masterDO.getQuantity() - NumberUtil.parseInt(StrUtil.toString(itemDO.getNum())));
        // 判断子订单是否都已取消，都取消则将主订单也取消
        List<BookingMasterItemVO> voList = itemService.selectByOrderId(itemDO.getOrderId());
        Long itemCancelCount = voList.stream()
                .filter(item -> ObjectUtil.equals(item.getStatus(), MasterStatusCode.CANCELED.getCode())).count();
        if (ObjectUtil.equals(voList.size() - 1, NumberUtil.parseInt(itemCancelCount.toString()))) {
            masterDO.setCancelTime(LocalDateTime.now());
        }
        masterService.updateById(masterDO);

        // 添加截止时间
        ruleDO.setEndTime(itemDO.getDep().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        // 创建取消规则
        save(ruleDO);

        // 订单更新取消规则id，name
        itemDO.setCancelRuleId(ruleDO.getId());
        itemDO.setCancelRuleName(ruleDO.getName());
        itemDO.setCancelTime(LocalDateTime.now());

        // 创建订单扣除对应的渠道产品信息
        if (ObjectUtil.isNull(itemDO.getNum())) {
            itemDO.setNum(NumberUtil.toBigDecimal(0));
        }
        // 找到对应的当天库存信息
        List<CmmProductDailyAmountDO> amountList = amountService.selectByProductId(itemDO.getProductId());
        CmmProductDailyAmountDO amountDO = new CmmProductDailyAmountDO();
        for (CmmProductDailyAmountDO item : amountList) {
            if (ObjectUtil.equals(LocalDate.now(), item.getSellDate())) {
                amountDO = item;
            }
        }

        // 归还库存
        int num = amountDO.getNum() + Integer.parseInt(itemDO.getNum().toString());
        amountDO.setNum(num);

        // 已使用数量归还
        if (ObjectUtil.isNull(amountDO.getUsedNum())) {
            amountDO.setUsedNum(0);
        }
        amountDO.setUsedNum(amountDO.getUsedNum() - Integer.parseInt(itemDO.getNum().toString()));

        // 更新库存信息
        UpdateCmmProductDailyAmountDTO amountDTO = new UpdateCmmProductDailyAmountDTO();
        amountDTO.setNum(amountDO.getNum());
        amountDTO.setUsedNum(amountDO.getUsedNum());
        amountService.update(amountDTO, amountDO.getId());

        // 更新订单状态
        itemService.canceled(itemDO.getId());
        // 更新订单金额
        itemService.updateById(itemDO);

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
