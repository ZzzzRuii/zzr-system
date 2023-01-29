package com.zzr.apollo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.nacos.shaded.com.google.common.base.Preconditions;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.api.ResultCode;
import com.zzr.apollo.exception.ServiceException;
import com.zzr.apollo.mapper.BookingMasterRefundMapper;
import com.zzr.apollo.master.dto.CreateBookingMasterRefundDTO;
import com.zzr.apollo.master.dto.CreateBookingMasterRefundItemDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterRefundDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterRefundDTO;
import com.zzr.apollo.master.vo.BookingMasterItemVO;
import com.zzr.apollo.master.vo.BookingMasterRefundVO;
import com.zzr.apollo.model.BookingMasterDO;
import com.zzr.apollo.model.BookingMasterRefundDO;
import com.zzr.apollo.service.IBookingMasterItemService;
import com.zzr.apollo.service.IBookingMasterRefundItemService;
import com.zzr.apollo.service.IBookingMasterRefundService;
import com.zzr.apollo.service.IBookingMasterService;
import com.zzr.apollo.support.Condition;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;
import com.zzr.apollo.tool.constants.MasterStatusCode;
import com.zzr.apollo.tool.constants.RefundStatusCode;
import com.zzr.apollo.wrapper.BookingMasterRefundWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * 主订单退款 服务实现类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 14:02
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BookingMasterRefundServiceImpl extends ZzrServiceImpl<BookingMasterRefundMapper, BookingMasterRefundDO> implements IBookingMasterRefundService {

    private final IBookingMasterService masterService;

    private final IBookingMasterItemService itemService;

    private final IBookingMasterRefundItemService refundItemService;

    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    @Override
    public BookingMasterRefundDO detail(Long id) {
        return baseMapper.selectById(id);
    }

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param refundDTO
     * @return
     */
    @Override
    public Page<BookingMasterRefundVO> selectPage(Query query, QueryBookingMasterRefundDTO refundDTO) {
        // 存入分页参数
        IPage<BookingMasterRefundDO> page = Condition.getPage(query);
        page.setRecords(baseMapper.selectMasterRefundInfo(page, refundDTO));
        return BookingMasterRefundWrapper.build().pageVO(page);
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param refundDTO
     * @return
     */
    @Override
    public BookingMasterRefundDO create(CreateBookingMasterRefundDTO refundDTO) {
        // DTO中使用注解进行校验，必填数据是否为空
        BookingMasterRefundDO refundDO = BookingMasterRefundWrapper.build().voEntity(refundDTO);

        // 获取主订单中数据
        BookingMasterDO masterDO = masterService.detail(refundDO.getOrderId());
        BeanUtil.copyProperties(masterDO, refundDO);
        refundDO.setQuantity(NumberUtil.toBigDecimal(masterDO.getQuantity()));

        // 创建退款订单号码
        refundDO.setRefundOrderNo(String.valueOf(UUID.randomUUID()));
        // 退款时间	审核时间
        refundDO.setPayTime(LocalDateTime.now());
        refundDO.setAuditTime(LocalDateTime.now());
        refundDO.setIsAudit(true);

        // 子订单一同退款
        List<BookingMasterItemVO> itemList = itemService.selectByOrderId(refundDO.getOrderId());
        itemList.forEach(item -> {
            CreateBookingMasterRefundItemDTO refundItemDTO = new CreateBookingMasterRefundItemDTO();
            refundItemDTO.setOrderItemId(item.getId());
            if (!ObjectUtil.equals(item.getStatus(), MasterStatusCode.CANCELED)
                    || !ObjectUtil.equals(item.getRefund(), true)) {
                refundItemService.create(refundItemDTO);
            }
        });

        save(refundDO);

        // 完成
        status(refundDO.getId(), RefundStatusCode.COMPLETE.getCode());

        return refundDO;
    }

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param refundDTO
     * @param id
     * @return
     */
    @Override
    public Boolean update(UpdateBookingMasterRefundDTO refundDTO, Long id) {
        // 检查数据是否存在
        BookingMasterRefundDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        BookingMasterRefundDO masterRefundDO = BookingMasterRefundWrapper.build().voEntity(refundDTO);
        masterRefundDO.setId(id);
        return updateById(masterRefundDO);
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
        BookingMasterRefundDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        return baseMapper.deleteById(id) != 0;
    }

    /**
     * 根据主键 修改状态
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @param status
     * @return
     */
    @Override
    public Boolean status(Long id, String status) {
        BookingMasterRefundDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());
        // 判断状态是否正确
        RefundStatusCode refundStatus = RefundStatusCode.of(status);
        if (ObjectUtil.isNull(refundStatus)) {
            throw new ServiceException(ResultCode.SC_NO_CONTENT);
        }
        entity.setStatus(status);
        return changeStatus(entity);
    }

}