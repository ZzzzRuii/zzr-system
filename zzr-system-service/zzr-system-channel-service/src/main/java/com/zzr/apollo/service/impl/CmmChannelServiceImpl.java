package com.zzr.apollo.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.nacos.shaded.com.google.common.base.Preconditions;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.channel.dto.CreateCmmChannelDTO;
import com.zzr.apollo.channel.dto.QueryCmmChannelDTO;
import com.zzr.apollo.channel.dto.UpdateCmmChannelDTO;
import com.zzr.apollo.channel.vo.CmmChannelVO;
import com.zzr.apollo.mapper.CmmChannelMapper;
import com.zzr.apollo.model.CmmChannelDO;
import com.zzr.apollo.service.ICmmChannelService;
import com.zzr.apollo.tool.constants.DemoResultCode;
import com.zzr.apollo.tool.constants.DemoStatusCode;
import com.zzr.apollo.wrapper.CmmChannelWrapper;
import com.zzr.base.api.ResultCode;
import com.zzr.base.service.impl.ZzrServiceImpl;
import com.zzr.base.support.Condition;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 渠道服务实现类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 16:21
 */
@Service
public class CmmChannelServiceImpl extends ZzrServiceImpl<CmmChannelMapper, CmmChannelDO> implements ICmmChannelService {
    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    @Override
    public CmmChannelDO detail(Long id) {
        return baseMapper.selectById(id);
    }

    /**
     * 根据参数 查询数据
     * 分页
     *
     * @param channelDTO
     * @return
     */
    @Override
    public Page<CmmChannelVO> selectPage(Query query, QueryCmmChannelDTO channelDTO) {
        IPage<CmmChannelDO> page = Condition.getPage(query);
        page.setRecords(baseMapper.selectChannelPage(page, channelDTO));
        return CmmChannelWrapper.build().pageVO(page);
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param channelDTO
     * @return
     */
    @Override
    public CmmChannelDO create(CreateCmmChannelDTO channelDTO) {

        CmmChannelDO channelDO = CmmChannelWrapper.build().dtoEntity(channelDTO);

        // 确保 code 唯一性
        Preconditions.checkArgument(codeUniqueness(channelDO.getCode()), DemoResultCode.DATA_ALREADY_EXIST.getMessage());

        // 确保 name 唯一性
        Preconditions.checkArgument(nameUniqueness(channelDO.getName()), DemoResultCode.DATA_ALREADY_EXIST.getMessage());

        save(channelDO);

        return channelDO;
    }

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param channelDTO
     * @param id
     * @return
     */
    @Override
    public Boolean update(UpdateCmmChannelDTO channelDTO, Long id) {
        // 检查数据是否存在
        CmmChannelDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        CmmChannelDO channelDO = CmmChannelWrapper.build().dtoEntity(channelDTO);
        channelDO.setId(id);

        return updateById(channelDO);
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
        CmmChannelDO entity = detail(id);
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
        CmmChannelDO entity = detail(id);
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
        CmmChannelDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());
        // 判断状态是否正确
        if (ObjectUtil.isNotNull(DemoStatusCode.of(entity.getStatus()))) {
            entity.setStatus(DemoStatusCode.ACTIVATE.getCode());
        }
        return changeStatus(entity);
    }


    /**
     * 根据参数 查询数据
     * 列表
     *
     * @param channelDTO
     * @return
     */
    private List<CmmChannelDO> selectList(QueryCmmChannelDTO channelDTO) {
        return baseMapper.selectChannelList(channelDTO);
    }

    /**
     * 根据参数 查询数据
     * 判断参数是否唯一
     *
     * @param name
     * @return
     */
    private Boolean nameUniqueness(String name) {
        QueryCmmChannelDTO queryDTO = new QueryCmmChannelDTO();
        queryDTO.setName(name);
        List<CmmChannelDO> paramList = selectList(queryDTO);

        return ObjectUtil.isEmpty(paramList);
    }

    /**
     * 根据参数 查询数据
     * 判断参数是否唯一
     *
     * @param code
     * @return
     */
    private Boolean codeUniqueness(String code) {
        QueryCmmChannelDTO queryDTO = new QueryCmmChannelDTO();
        queryDTO.setCode(code);
        List<CmmChannelDO> paramList = selectList(queryDTO);

        return ObjectUtil.isEmpty(paramList);
    }
}
