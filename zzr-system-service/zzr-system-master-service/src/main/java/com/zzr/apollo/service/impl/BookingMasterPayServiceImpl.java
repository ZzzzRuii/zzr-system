package com.zzr.apollo.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.api.ResultCode;
import com.zzr.apollo.exception.ServiceException;
import com.zzr.apollo.mapper.BookingMasterPayMapper;
import com.zzr.apollo.master.dto.CreateBookingMasterPayDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterPayDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterPayDTO;
import com.zzr.apollo.master.vo.BookingMasterPayVO;
import com.zzr.apollo.model.BookingMasterDO;
import com.zzr.apollo.model.BookingMasterPayDO;
import com.zzr.apollo.service.IBookingMasterPayService;
import com.zzr.apollo.service.IBookingMasterService;
import com.zzr.apollo.support.Condition;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;
import com.zzr.apollo.tool.constants.DemoStatusCode;
import com.zzr.apollo.tool.constants.PayStatusCode;
import com.zzr.apollo.wrapper.BookingMasterPayWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 订单支付 服务实现类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:50
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BookingMasterPayServiceImpl extends ZzrServiceImpl<BookingMasterPayMapper, BookingMasterPayDO> implements IBookingMasterPayService {

    private final IBookingMasterService masterService;

    @Override
    public BookingMasterPayDO detail(Long id) {
        return baseMapper.selectById(id);
    }

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param payDTO
     * @return
     */
    @Override
    public Page<BookingMasterPayVO> selectPage(Query query, QueryBookingMasterPayDTO payDTO) {
        IPage<BookingMasterPayDO> page = Condition.getPage(query);
        page.setRecords(baseMapper.selectPayPage(page, payDTO));

        return BookingMasterPayWrapper.build().pageVO(page);
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param payDTO
     * @return
     */
    @Override
    public BookingMasterPayDO create(CreateBookingMasterPayDTO payDTO) {
        BookingMasterPayDO payDO = BookingMasterPayWrapper.build().voEntity(payDTO);

        BookingMasterDO masterDO = masterService.detail(payDO.getOrderId());
        payDO.setTenantId(masterDO.getTenantId());
        payDO.setCurrency(masterDO.getCurrency());
        payDO.setAmount(masterDO.getFinalFee());
        payDO.setRemark(StrUtil.builder(masterDO.getBuyMemo(), ",", payDO.getRemark()).toString());

        save(payDO);

        // 主订单更新
        masterDO.setPayTime(LocalDateTime.now());
        masterDO.setPayType(payDTO.getTransactionCode());
        masterDO.setPaymentStatus(PayStatusCode.PAY);
        masterService.updateById(masterDO);
        masterService.rePay(masterDO.getId());

        // 激活
        activate(payDO.getId());

        return payDO;
    }

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param payDTO
     * @param id
     * @return
     */
    @Override
    public Boolean update(UpdateBookingMasterPayDTO payDTO, Long id) {
        BookingMasterPayDO entity = detail(id);
        if (ObjectUtil.isEmpty(entity)) {
            throw new ServiceException(ResultCode.SC_NO_CONTENT);
        }

        BookingMasterPayDO payDO = BookingMasterPayWrapper.build().voEntity(payDTO);

        payDO.setId(id);
        return updateById(payDO);
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
        BookingMasterPayDO entity = detail(id);
        if (ObjectUtil.isEmpty(entity)) {
            throw new ServiceException(ResultCode.SC_NO_CONTENT);
        }

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
        BookingMasterPayDO entity = detail(id);
        if (ObjectUtil.isEmpty(entity)) {
            throw new ServiceException(ResultCode.SC_NO_CONTENT);
        }

        if (StrUtil.equals(entity.getStatus(), DemoStatusCode.ACTIVATE.getCode())) {
            entity.setStatus(DemoStatusCode.INACTIVE.getCode());
        }
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
        BookingMasterPayDO entity = detail(id);
        if (ObjectUtil.isEmpty(entity)) {
            throw new ServiceException(ResultCode.SC_NO_CONTENT);
        }

        if (StrUtil.equals(entity.getStatus(), DemoStatusCode.INACTIVE.getCode())) {
            entity.setStatus(DemoStatusCode.ACTIVATE.getCode());
        }
        return changeStatus(entity);
    }
}