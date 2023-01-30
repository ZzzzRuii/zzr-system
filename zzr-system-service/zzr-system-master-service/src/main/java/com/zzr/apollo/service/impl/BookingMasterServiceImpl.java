package com.zzr.apollo.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.nacos.shaded.com.google.common.base.Preconditions;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.mapper.BookingMasterMapper;
import com.zzr.apollo.master.dto.CreateBookingMasterDTO;
import com.zzr.apollo.master.dto.QueryBookingMasterDTO;
import com.zzr.apollo.master.dto.UpdateBookingMasterDTO;
import com.zzr.apollo.master.vo.BookingMasterVO;
import com.zzr.apollo.model.BookingMasterDO;
import com.zzr.apollo.service.IBookingMasterService;
import com.zzr.apollo.service.ICmmChannelService;
import com.zzr.apollo.tool.constants.DemoResultCode;
import com.zzr.apollo.tool.constants.MasterStatusCode;
import com.zzr.apollo.tool.constants.PayStatusCode;
import com.zzr.apollo.wrapper.BookingMasterWrapper;
import com.zzr.base.api.ResultCode;
import com.zzr.base.service.impl.ZzrServiceImpl;
import com.zzr.base.support.Condition;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 主订单 服务实现类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:52
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BookingMasterServiceImpl extends ZzrServiceImpl<BookingMasterMapper, BookingMasterDO> implements IBookingMasterService {

    private final ICmmChannelService channelService;

    @Override
    public BookingMasterDO detail(Long id) {
        return baseMapper.selectById(id);
    }

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param bookingMaster
     * @return
     */
    @Override
    public Page<BookingMasterVO> selectPage(Query query, QueryBookingMasterDTO bookingMaster) {
        // 存入分页参数
        IPage<BookingMasterDO> page = Condition.getPage(query);
        page.setRecords(baseMapper.selectMasterInfo(page, bookingMaster));
        return BookingMasterWrapper.build().pageVO(page);
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param bookingMaster
     * @return
     */
    @Override
    public BookingMasterDO create(CreateBookingMasterDTO bookingMaster) {
        // DTO中使用注解进行校验，必填数据是否为空
        BookingMasterDO masterDO = BookingMasterWrapper.build().voEntity(bookingMaster);

        masterDO.setConfirmNo(RandomUtil.randomNumbers(10));

        masterDO.setChannelCode(channelService.detail(masterDO.getChannelId()).getCode());

        BookingMasterDO unit = baseMapper.selectByUnitId(masterDO.getUnitId());
        Preconditions.checkNotNull(unit, DemoResultCode.UNIT_NOT_EXISTS.getMessage());
        masterDO.setUnitType(unit.getUnitType());
        masterDO.setTenantId(unit.getTenantId());

        masterDO.setPaymentStatus(PayStatusCode.NOT_PAY);

        save(masterDO);

        return masterDO;
    }

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param bookingMaster
     * @param id
     * @return
     */
    @Override
    public Boolean update(UpdateBookingMasterDTO bookingMaster, Long id) {
        // 检查数据是否存在
        BookingMasterDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        BookingMasterDO bookingMasterDO = BookingMasterWrapper.build().voEntity(bookingMaster);
        bookingMasterDO.setId(id);
        return updateById(bookingMasterDO);
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
        BookingMasterDO entity = detail(id);
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
        BookingMasterDO entity = detail(id);
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
        BookingMasterDO entity = detail(id);
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
        BookingMasterDO entity = detail(id);
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
        BookingMasterDO entity = detail(id);
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
        BookingMasterDO entity = detail(id);
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
        BookingMasterDO entity = detail(id);
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
        BookingMasterDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        entity.setStatus(MasterStatusCode.COMPLETE.getCode());
        return changeStatus(entity);
    }
}
