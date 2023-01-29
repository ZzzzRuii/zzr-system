package com.zzr.apollo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.nacos.shaded.com.google.common.base.Preconditions;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.api.ResultCode;
import com.zzr.apollo.channel.dto.CreateCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.dto.QueryCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.dto.UpdateCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.vo.CmmProductDailyAmountVO;
import com.zzr.apollo.mapper.CmmProductDailyAmountMapper;
import com.zzr.apollo.model.CmmProductDailyAmountDO;
import com.zzr.apollo.service.ICmmProductDailyAmountService;
import com.zzr.apollo.support.Condition;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;
import com.zzr.apollo.tool.constants.AmountModelCode;
import com.zzr.apollo.tool.constants.DemoStatusCode;
import com.zzr.apollo.wrapper.CmmProductDailyAmountWrapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 库存服务实现类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 17:12
 */
@Service
public class CmmProductDailyAmountServiceImpl extends ZzrServiceImpl<CmmProductDailyAmountMapper, CmmProductDailyAmountDO> implements ICmmProductDailyAmountService {
    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    @Override
    public CmmProductDailyAmountDO detail(Long id) {
        return baseMapper.selectById(id);
    }

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param amountDTO
     * @return
     */
    @Override
    public Page<CmmProductDailyAmountVO> selectPage(Query query, QueryCmmProductDailyAmountDTO amountDTO) {
        IPage<CmmProductDailyAmountDO> page = Condition.getPage(query);
        page.setRecords(baseMapper.selectAmountPage(page, amountDTO));

        return CmmProductDailyAmountWrapper.build().pageVO(page);
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param amountDTO
     * @return
     */
    @Override
    public List<Long> create(CreateCmmProductDailyAmountDTO amountDTO) {
        CmmProductDailyAmountDO amountDO = CmmProductDailyAmountWrapper.build().dtoEntity(amountDTO);

        List<CmmProductDailyAmountDO> doList = paramCheck(amountDO);
        saveBatch(doList);

        List<Long> idList = CollUtil.newArrayList();
        doList.forEach(item -> {
            idList.add(item.getId());
        });

        return idList;
    }

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param amountDTO
     * @param id
     * @return
     */
    @Override
    public Boolean update(UpdateCmmProductDailyAmountDTO amountDTO, Long id) {
        // 检查数据是否存在
        CmmProductDailyAmountDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        CmmProductDailyAmountDO amountDO = CmmProductDailyAmountWrapper.build().dtoEntity(amountDTO);
        amountDO.setId(id);

        return updateById(amountDO);
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
        CmmProductDailyAmountDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

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
        CmmProductDailyAmountDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());
        // 判断状态是否正确
        if (ObjectUtil.isNotNull(DemoStatusCode.of(entity.getStatus()))) {
            entity.setStatus(DemoStatusCode.INACTIVE.getCode());
        }
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
        CmmProductDailyAmountDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());
        // 判断状态是否正确
        if (ObjectUtil.isNotNull(DemoStatusCode.of(entity.getStatus()))) {
            entity.setStatus(DemoStatusCode.ACTIVATE.getCode());
        }
        return changeStatus(entity);
    }

    /**
     * 根据产品ID查询
     *
     * @param productId
     * @return
     */
    @Override
    public List<CmmProductDailyAmountDO> selectByProductId(Long productId) {
        return baseMapper.selectByProductId(productId);
    }


    /**
     * 检查参数
     *
     * @param amountDO
     * @return
     */
    private List<CmmProductDailyAmountDO> paramCheck(CmmProductDailyAmountDO amountDO) {

        // 产品数据接收 在listener中调用创建，并获取产品的某些数据
        Integer num = amountDO.getNum();

        // 判断库存模式
        switch (amountDO.getModel()) {
            case AmountModelCode.DAILY_FIXED:
                amountDO.setNum(num);
                break;
            case AmountModelCode.UNLIMITED:
                amountDO.setNum(Integer.MAX_VALUE);
                break;
            case AmountModelCode.TOTAL:
                amountDO.setNum(num / AmountModelCode.DEFAULT_DATE);
                break;
            default:
                break;
        }

        // 创建60条库存记录
        List<CmmProductDailyAmountDO> doList = new ArrayList<>();
        for (int i = 0; i < AmountModelCode.DEFAULT_DATE; i++) {
            CmmProductDailyAmountDO entity = new CmmProductDailyAmountDO();
            BeanUtil.copyProperties(amountDO, entity);
            entity.setSellDate(LocalDate.now().plusDays(i));
            doList.add(entity);
        }

        return doList;
    }
}
