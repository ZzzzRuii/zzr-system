package com.zzr.apollo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.nacos.shaded.com.google.common.base.Preconditions;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.api.ResultCode;
import com.zzr.apollo.exception.ServiceException;
import com.zzr.apollo.mapper.BookingMasterItemMapper;
import com.zzr.apollo.master.dto.CreateBookingMasterItemDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterItemDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterItemDTO;
import com.zzr.apollo.master.vo.BookingMasterItemVO;
import com.zzr.apollo.model.BookingMasterItemDO;
import com.zzr.apollo.model.CmmProductDailyAmountDO;
import com.zzr.apollo.model.ProductTicketDO;
import com.zzr.apollo.service.IBookingMasterItemService;
import com.zzr.apollo.service.ICmmProductDailyAmountService;
import com.zzr.apollo.service.IProductTicketService;
import com.zzr.apollo.support.Condition;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;
import com.zzr.apollo.tool.constants.DemoResultCode;
import com.zzr.apollo.tool.constants.MasterStatusCode;
import com.zzr.apollo.wrapper.BookingMasterItemWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * 子订单 服务实现类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:42
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BookingMasterItemServiceImpl extends ZzrServiceImpl<BookingMasterItemMapper, BookingMasterItemDO> implements IBookingMasterItemService {

    private final IProductTicketService productService;

    private final ICmmProductDailyAmountService amountService;

    @Override
    public BookingMasterItemDO detail(Long id) {
        return baseMapper.selectById(id);
    }

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param bookingMasterItem
     * @return
     */
    @Override
    public Page<BookingMasterItemVO> selectPage(Query query, QueryBookingMasterItemDTO bookingMasterItem) {
        IPage<BookingMasterItemDO> page = Condition.getPage(query);
        page.setRecords(baseMapper.selectMasterItemInfo(page, bookingMasterItem));

        return BookingMasterItemWrapper.build().pageVO(page);
    }

    /**
     * 根据 orderId 查询数据
     *
     * @param orderId
     * @return
     */
    @Override
    public List<BookingMasterItemVO> selectByOrderId(Long orderId) {
        List<BookingMasterItemDO> doList = baseMapper.selectByOrderId(orderId);
        List<BookingMasterItemVO> voList = CollUtil.newArrayList();
        doList.forEach(item -> {
            voList.add(BookingMasterItemWrapper.build().entityVO(item));
        });

        return voList;
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param bookingMasterItem
     * @return
     */
    @Override
    public BookingMasterItemDO create(CreateBookingMasterItemDTO bookingMasterItem) {
        // DTO中使用注解检查必填字段是否为空
        BookingMasterItemDO itemDO = BookingMasterItemWrapper.build().voEntity(bookingMasterItem);

        // 数据处理
        paramCheck(itemDO);

        // 金额计算
        calculateAmount(itemDO);

        // 创建子订单
        save(itemDO);

        return itemDO;
    }

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param bookingMasterItem
     * @param id
     * @return
     */
    @Override
    public Boolean update(UpdateBookingMasterItemDTO bookingMasterItem, Long id) {
        // 检查数据是否存在
        BookingMasterItemDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        BookingMasterItemDO bookingMasterItemDO = BookingMasterItemWrapper.build().voEntity(bookingMasterItem);
        bookingMasterItemDO.setId(id);

        return updateById(bookingMasterItemDO);
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
        BookingMasterItemDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        return baseMapper.deleteById(id) != 0;
    }

    /**
     * 根据主键 预付款
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean reserve(Long id) {
        BookingMasterItemDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        entity.setStatus(MasterStatusCode.RESERVE.getCode());
        return changeStatus(entity);
    }

    /**
     * 根据主键 已付款
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean rePay(Long id) {
        BookingMasterItemDO itemDO = detail(id);
        Preconditions.checkNotNull(itemDO, ResultCode.SC_NO_CONTENT.getMessage());

        itemDO.setStatus(MasterStatusCode.REPAY.getCode());
        return changeStatus(itemDO);
    }

    /**
     * 根据主键 已取消
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean canceled(Long id) {
        BookingMasterItemDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        entity.setStatus(MasterStatusCode.CANCELED.getCode());
        return changeStatus(entity);
    }

    /**
     * 根据主键 确认中
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean confirming(Long id) {
        BookingMasterItemDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        entity.setStatus(MasterStatusCode.CONFIRMING.getCode());
        return changeStatus(entity);
    }

    /**
     * 根据主键 已确认
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean confirmed(Long id) {
        BookingMasterItemDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        entity.setStatus(MasterStatusCode.CONFIRMED.getCode());
        return changeStatus(entity);
    }

    /**
     * 根据主键 执行中
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean doing(Long id) {
        BookingMasterItemDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        entity.setStatus(MasterStatusCode.DOING.getCode());
        return changeStatus(entity);
    }

    /**
     * 根据主键 完成
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean complete(Long id) {
        BookingMasterItemDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        entity.setStatus(MasterStatusCode.COMPLETE.getCode());
        return changeStatus(entity);
    }

    /**
     * 数据处理
     *
     * @param itemDO
     */
    private void paramCheck(BookingMasterItemDO itemDO) {
        // 获取产品信息，并填入子订单中
        ProductTicketDO productDO = productService.detail(itemDO.getProductId());
        Preconditions.checkNotNull(productDO, ResultCode.SC_NO_CONTENT.getMessage());
        itemDO.setProductCode(productDO.getCode());
        itemDO.setProductName(productDO.getName());
        itemDO.setProductKind(productDO.getCatalog());
        itemDO.setOriginalPrice(productDO.getStandardPrice());
        itemDO.setCostPrice(productDO.getCostPrice());
        itemDO.setPrice(productDO.getRealPrice());

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

        // 记录扣除后可买数量
        Integer num = amountDO.getNum() - Integer.parseInt(itemDO.getNum().toString());

        // 判断可买数量是否足够，超出可买数量则提示库存不足
        if (num < 0) {
            throw new ServiceException(DemoResultCode.UNDER_STOCK);
        }
        // 库存足够，则记录库存，已使用数量
        if (ObjectUtil.isNull(amountDO.getUsedNum())) {
            amountDO.setUsedNum(0);
        }
        amountDO.setNum(num);
        amountDO.setUsedNum(amountDO.getUsedNum() + Integer.parseInt(itemDO.getNum().toString()));

        // 更新库存数据，扣除库存
        amountService.updateById(amountDO);
    }

    /**
     * 金额计算
     *
     * @param itemDO
     */
    @Override
    public void calculateAmount(BookingMasterItemDO itemDO) {
        // 计算订单总金额 = ( 最终价格 * 数量 )
        BigDecimal sum = itemDO.getPrice().multiply(itemDO.getNum());
        itemDO.setTotalFee(sum);

        // 计算实际订单金额 = 总金额 - 折扣金额
        BigDecimal finalSum = itemDO.getTotalFee();
        if (ObjectUtil.isNotNull(itemDO.getDiscountFee())) {
            finalSum = finalSum.subtract(itemDO.getDiscountFee());
        }
        itemDO.setFinalFee(finalSum);
    }
}
