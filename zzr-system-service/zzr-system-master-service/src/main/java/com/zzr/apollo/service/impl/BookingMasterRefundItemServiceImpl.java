package com.zzr.apollo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.nacos.shaded.com.google.common.base.Preconditions;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.channel.dto.UpdateCmmProductDailyAmountDTO;
import com.zzr.apollo.mapper.BookingMasterRefundItemMapper;
import com.zzr.apollo.master.dto.CreateBookingMasterRefundItemDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterRefundItemDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterRefundItemDTO;
import com.zzr.apollo.master.vo.BookingMasterRefundItemVO;
import com.zzr.apollo.model.BookingMasterDO;
import com.zzr.apollo.model.BookingMasterItemDO;
import com.zzr.apollo.model.BookingMasterRefundItemDO;
import com.zzr.apollo.model.CmmProductDailyAmountDO;
import com.zzr.apollo.service.IBookingMasterItemService;
import com.zzr.apollo.service.IBookingMasterRefundItemService;
import com.zzr.apollo.service.IBookingMasterService;
import com.zzr.apollo.service.ICmmProductDailyAmountService;
import com.zzr.apollo.tool.constants.MasterStatusCode;
import com.zzr.apollo.wrapper.BookingMasterRefundItemWrapper;
import com.zzr.base.api.ResultCode;
import com.zzr.base.service.impl.ZzrServiceImpl;
import com.zzr.base.support.Condition;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * 子订单退款 服务实现类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:55
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BookingMasterRefundItemServiceImpl extends ZzrServiceImpl<BookingMasterRefundItemMapper, BookingMasterRefundItemDO> implements IBookingMasterRefundItemService {

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
    public BookingMasterRefundItemDO detail(Long id) {
        return baseMapper.selectById(id);
    }

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param refundItemDTO
     * @return
     */
    @Override
    public Page<BookingMasterRefundItemVO> selectPage(Query query, QueryBookingMasterRefundItemDTO refundItemDTO) {
        // 存入分页参数
        IPage<BookingMasterRefundItemDO> page = Condition.getPage(query);
        page.setRecords(baseMapper.selectMasterRefundItemInfo(page, refundItemDTO));
        return BookingMasterRefundItemWrapper.build().pageVO(page);
    }

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param refundItemDTO
     * @param id
     * @return
     */
    @Override
    public Boolean update(UpdateBookingMasterRefundItemDTO refundItemDTO, Long id) {
        // 检查数据是否存在
        BookingMasterRefundItemDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        BookingMasterRefundItemDO refundItemDO = BookingMasterRefundItemWrapper.build().voEntity(refundItemDTO);
        refundItemDO.setId(id);
        return updateById(refundItemDO);
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
        BookingMasterRefundItemDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        return baseMapper.deleteById(id) != 0;
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param refundItemDTO
     * @return
     */
    @Override
    public BookingMasterRefundItemDO create(CreateBookingMasterRefundItemDTO refundItemDTO) {
        // DTO中使用注解进行校验，必填数据是否为空
        BookingMasterRefundItemDO refundItemDO = BookingMasterRefundItemWrapper.build().voEntity(refundItemDTO);

        // 将子订单中信息拷贝到子订单退款信息中
        BookingMasterItemDO itemDO = itemService.detail(refundItemDO.getOrderItemId());
        BeanUtil.copyProperties(itemDO, refundItemDO);

        // 创建订单扣除对应的渠道产品信息
        if (ObjectUtil.isNull(refundItemDO.getNum())) {
            refundItemDO.setNum(NumberUtil.toBigDecimal(0));
        }
        // 找到对应的当天库存信息
        List<CmmProductDailyAmountDO> amountList = amountService.selectByProductId(refundItemDO.getProductId());
        CmmProductDailyAmountDO amountDO = new CmmProductDailyAmountDO();
        for (CmmProductDailyAmountDO item : amountList) {
            if (ObjectUtil.equals(LocalDate.now(), item.getSellDate())) {
                amountDO = item;
            }
        }

        // 归还库存
        int num = amountDO.getNum() + Integer.parseInt(refundItemDO.getNum().toString());
        amountDO.setNum(num);

        // 已使用数量归还
        if (ObjectUtil.isNull(amountDO.getUsedNum())) {
            amountDO.setUsedNum(0);
        }
        amountDO.setUsedNum(amountDO.getUsedNum() - Integer.parseInt(refundItemDO.getNum().toString()));

        // 更新库存信息
        UpdateCmmProductDailyAmountDTO amountDTO = new UpdateCmmProductDailyAmountDTO();
        amountDTO.setNum(amountDO.getNum());
        amountDTO.setUsedNum(amountDO.getUsedNum());
        amountService.update(amountDTO, amountDO.getId());

        // 更新主订单信息
        BookingMasterDO masterDO = masterService.detail(itemDO.getOrderId());
        masterDO.setTotalFee(masterDO.getTotalFee().subtract(itemDO.getFinalFee()));
        if (ObjectUtil.equals(masterDO.getTotalFee(), 0)) {
            masterDO.setFinalFee(masterDO.getTotalFee());
        } else {
            masterDO.setFinalFee(masterDO.getTotalFee().subtract(masterDO.getDiscountFee()));
        }
        masterDO.setQuantity(masterDO.getQuantity() - NumberUtil.parseInt(StrUtil.toString(itemDO.getNum())));
        masterService.updateById(masterDO);

        // 更新子订单信息，逻辑删除子订单
        itemDO.setDeleted(true);
        itemDO.setRefund(true);
        itemDO.setRefundNum(itemDO.getNum());
        itemService.updateById(itemDO);


        // 创建退款
        save(refundItemDO);

        // 完成退款
        complete(refundItemDO.getId());

        return refundItemDO;
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
        BookingMasterRefundItemDO entity = detail(id);
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
        BookingMasterRefundItemDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        entity.setStatus(MasterStatusCode.REPAY.getCode());
        return changeStatus(entity);
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
        BookingMasterRefundItemDO entity = detail(id);
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
        BookingMasterRefundItemDO entity = detail(id);
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
        BookingMasterRefundItemDO entity = detail(id);
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
        BookingMasterRefundItemDO entity = detail(id);
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
        BookingMasterRefundItemDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        entity.setStatus(MasterStatusCode.COMPLETE.getCode());
        return changeStatus(entity);
    }
}
