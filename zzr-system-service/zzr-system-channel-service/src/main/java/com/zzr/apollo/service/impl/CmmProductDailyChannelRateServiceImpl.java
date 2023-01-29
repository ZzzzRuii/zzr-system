package com.zzr.apollo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.nacos.shaded.com.google.common.base.Preconditions;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.api.ResultCode;
import com.zzr.apollo.channel.dto.CreateCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.dto.QueryCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.dto.UpdateCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.vo.CmmProductDailyChannelRateVO;
import com.zzr.apollo.mapper.CmmProductDailyChannelRateMapper;
import com.zzr.apollo.model.CmmProductDailyChannelRateDO;
import com.zzr.apollo.service.ICmmProductDailyChannelRateService;
import com.zzr.apollo.support.Condition;
import com.zzr.apollo.support.Page;
import com.zzr.apollo.support.Query;
import com.zzr.apollo.tool.constants.AmountModelCode;
import com.zzr.apollo.tool.constants.DemoResultCode;
import com.zzr.apollo.tool.constants.DemoStatusCode;
import com.zzr.apollo.tool.constants.RateSrcCode;
import com.zzr.apollo.wrapper.CmmProductDailyChannelRateWrapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 每日价格服务实现类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 17:28
 */
@Service
public class CmmProductDailyChannelRateServiceImpl extends ZzrServiceImpl<CmmProductDailyChannelRateMapper, CmmProductDailyChannelRateDO> implements ICmmProductDailyChannelRateService {
    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    @Override
    public CmmProductDailyChannelRateDO detail(Long id) {
        return baseMapper.selectById(id);
    }

    /**
     * 根据产品ID查询
     *
     * @param productId
     * @return
     */
    @Override
    public List<CmmProductDailyChannelRateDO> selectByProductId(Long productId) {
        return baseMapper.selectByProductId(productId);
    }

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param query
     * @param rateDTO
     * @return
     */
    @Override
    public Page<CmmProductDailyChannelRateVO> selectPage(Query query, QueryCmmProductDailyChannelRateDTO rateDTO) {
        IPage<CmmProductDailyChannelRateDO> page = Condition.getPage(query);
        page.setRecords(baseMapper.selectRatePage(page, rateDTO));

        return CmmProductDailyChannelRateWrapper.build().pageVO(page);
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param rateDTO
     * @return
     */
    @Override
    public List<Long> create(CreateCmmProductDailyChannelRateDTO rateDTO) {
        CmmProductDailyChannelRateDO rateDO = CmmProductDailyChannelRateWrapper.build().dtoEntity(rateDTO);

        // 来源检测
        Preconditions.checkArgument(ObjectUtil.equals(rateDTO.getSrc(), RateSrcCode.INTERFACE)
                        || ObjectUtil.equals(rateDTO.getSrc(), RateSrcCode.MANUAL),
                DemoResultCode.SRC_ERROR.getMessage());

        List<CmmProductDailyChannelRateDO> doList = paramCheck(rateDO);
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
     * @param rateDTO
     * @param id
     * @return
     */
    @Override
    public Boolean update(UpdateCmmProductDailyChannelRateDTO rateDTO, Long id) {
        // 检查数据是否存在
        CmmProductDailyChannelRateDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        CmmProductDailyChannelRateDO rateDO = CmmProductDailyChannelRateWrapper.build().dtoEntity(rateDTO);
        rateDO.setId(id);

        return updateById(rateDO);
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
        CmmProductDailyChannelRateDO entity = detail(id);
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
        CmmProductDailyChannelRateDO entity = detail(id);
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
        CmmProductDailyChannelRateDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());
        // 判断状态是否正确
        if (ObjectUtil.isNotNull(DemoStatusCode.of(entity.getStatus()))) {
            entity.setStatus(DemoStatusCode.ACTIVATE.getCode());
        }
        return changeStatus(entity);
    }


    /**
     * 检查参数
     *
     * @param rateDO
     * @return
     */
    private List<CmmProductDailyChannelRateDO> paramCheck(CmmProductDailyChannelRateDO rateDO) {

        // 产品数据接收 在listener中调用创建，并获取产品的某些数据

        // 创建60条价格记录
        List<CmmProductDailyChannelRateDO> doList = new ArrayList<>();
        for (int i = 0; i < AmountModelCode.DEFAULT_DATE; i++) {
            CmmProductDailyChannelRateDO entity = new CmmProductDailyChannelRateDO();
            BeanUtil.copyProperties(rateDO, entity);
            entity.setSellDate(LocalDate.now().plusDays(i));
            doList.add(entity);
        }

        return doList;
    }
}
