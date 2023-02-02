package com.zzr.apollo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.nacos.shaded.com.google.common.base.Preconditions;
import com.zzr.apollo.mapper.SystemUnitChainInfoMapper;
import com.zzr.apollo.model.SystemUnitChainInfoDO;
import com.zzr.apollo.product.vo.ProductTicketVO;
import com.zzr.apollo.service.IProductTicketService;
import com.zzr.apollo.service.ISystemUnitChainInfoService;
import com.zzr.apollo.tool.constants.DemoResultCode;
import com.zzr.apollo.tool.constants.UnitStatusCode;
import com.zzr.apollo.unit.dto.CreateSystemUnitChainInfoDTO;
import com.zzr.apollo.unit.dto.QuerySystemUnitChainInfoDTO;
import com.zzr.apollo.unit.dto.UpdateSystemUnitChainInfoDTO;
import com.zzr.apollo.unit.vo.SystemUnitChainInfoVO;
import com.zzr.apollo.wrapper.SystemUnitChainInfoWrapper;
import com.zzr.base.api.ResultCode;
import com.zzr.base.service.impl.ZzrServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * SystemUnitChainInfoServiceImpl
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/29 15:48
 */
@Service
@RequiredArgsConstructor
public class SystemUnitChainInfoServiceImpl extends ZzrServiceImpl<SystemUnitChainInfoMapper, SystemUnitChainInfoDO> implements ISystemUnitChainInfoService {

    private final IProductTicketService productService;

    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    @Override
    public SystemUnitChainInfoDO detail(Long id) {
        return baseMapper.selectById(id);
    }

    /**
     * 根据参数 查询数据
     * 树状
     *
     * @param unitChainInfoDTO
     * @return
     */
    @Override
    public List<SystemUnitChainInfoVO> selectTree(QuerySystemUnitChainInfoDTO unitChainInfoDTO) {

        // 传入的 parentId 为空时，使根节点为 0
        if (ObjectUtil.isNull(unitChainInfoDTO.getParentId())) {
            unitChainInfoDTO.setParentId(0L);
        }

        List<Tree<String>> treeList = TreeUtil.build(list(), String.valueOf(unitChainInfoDTO.getParentId()),
                (node, tree) -> {
                    // 转换成 map，拓展获取其他字段值
                    Map<String, Object> treeMap = JSON.parseObject(JSON.toJSONString(node), new TypeReference<Map<String, Object>>() {
                    });

                    tree.putAll(treeMap);

                    // 获取组织下 产品信息
                    List<ProductTicketVO> productVOList = productService.selectByUnitId(node.getId());
                    tree.putExtra("product", productVOList);

                    tree.setId(String.valueOf(node.getId()));
                    tree.setParentId(String.valueOf(node.getParentId()));
                    tree.setWeight(node.getSort());
                });

        // 序列化再反序列化
        return JSON.parseArray(JSON.toJSONString(treeList), SystemUnitChainInfoVO.class);
    }

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param unitChainInfoDTO
     * @return
     */
    @Override
    public SystemUnitChainInfoDO create(CreateSystemUnitChainInfoDTO unitChainInfoDTO) {

        SystemUnitChainInfoDO infoDO = SystemUnitChainInfoWrapper.build().dtoEntity(unitChainInfoDTO);
        paramCheck(infoDO);
        save(infoDO);

        return infoDO;
    }

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param unitChainInfoDTO
     * @param id
     * @return
     */
    @Override
    public Boolean update(UpdateSystemUnitChainInfoDTO unitChainInfoDTO, Long id) {
        // 检查数据是否存在
        SystemUnitChainInfoDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        SystemUnitChainInfoDO infoDO = SystemUnitChainInfoWrapper.build().dtoEntity(unitChainInfoDTO);
        infoDO.setId(id);

        return updateById(infoDO);
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
        SystemUnitChainInfoDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());

        // 不允许删除有子项的父项，只能从子项开始删除
        QuerySystemUnitChainInfoDTO queryDTO = new QuerySystemUnitChainInfoDTO();
        queryDTO.setParentId(id);
        List<SystemUnitChainInfoDO> infoList = selectList(queryDTO);
        Preconditions.checkNotNull(CollUtil.isNotEmpty(infoList), DemoResultCode.PARENT_EXISTS.getMessage());

        return baseMapper.deleteById(id) != 0;
    }

    /**
     * 根据主键 停用数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean draft(Long id) {
        SystemUnitChainInfoDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());
        // 判断状态是否正确
        if (ObjectUtil.isNotNull(UnitStatusCode.of(entity.getStatus()))) {
            entity.setStatus(UnitStatusCode.DRAFT.getCode());
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
    public Boolean archived(Long id) {
        SystemUnitChainInfoDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());
        // 判断状态是否正确
        if (ObjectUtil.isNotNull(UnitStatusCode.of(entity.getStatus()))) {
            entity.setStatus(UnitStatusCode.ARCHIVED.getCode());
        }
        return changeStatus(entity);
    }

    /**
     * 根据主键 发布数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    @Override
    public Boolean published(Long id) {
        SystemUnitChainInfoDO entity = detail(id);
        Preconditions.checkNotNull(entity, ResultCode.SC_NO_CONTENT.getMessage());
        // 判断状态是否正确
        if (ObjectUtil.isNotNull(UnitStatusCode.of(entity.getStatus()))) {
            entity.setStatus(UnitStatusCode.PUBLISHED.getCode());
        }
        return changeStatus(entity);
    }


    /**
     * 根据参数 查询数据
     * 判断参数 是否唯一
     *
     * @param code
     */
    private Boolean codeUniqueness(String code) {

        QuerySystemUnitChainInfoDTO queryDTO = new QuerySystemUnitChainInfoDTO();
        queryDTO.setCode(code);
        List<SystemUnitChainInfoDO> paramList = selectList(queryDTO);

        return CollUtil.isEmpty(paramList);
    }

    /**
     * 根据参数 查询数据
     * 判断参数 是否唯一
     *
     * @param name
     */
    private Boolean nameUniqueness(String name) {

        QuerySystemUnitChainInfoDTO queryDTO = new QuerySystemUnitChainInfoDTO();
        queryDTO.setName(name);
        List<SystemUnitChainInfoDO> paramList = selectList(queryDTO);

        return CollUtil.isEmpty(paramList);
    }

    /**
     * 根据参数 查询数据
     * 判断参数 是否存在
     *
     * @param param
     * @return
     */
    private Boolean paramExists(Long param) {
        return ObjectUtil.isNotNull(detail(param));
    }

    /**
     * 检查参数是否唯一 是否存在
     *
     * @param unitChainInfoDO
     * @return
     */
    private SystemUnitChainInfoDO paramCheck(SystemUnitChainInfoDO unitChainInfoDO) {

        // 确保 code 唯一
        Preconditions.checkArgument(codeUniqueness(unitChainInfoDO.getCode()), DemoResultCode.DATA_ALREADY_EXIST.getMessage());

        // 确保 name 唯一
        Preconditions.checkArgument(nameUniqueness(unitChainInfoDO.getName()), DemoResultCode.DATA_ALREADY_EXIST.getMessage());

        // 判断 parentId 不为 0 和 null 时，父节点是否存在
        if (ObjectUtil.isNotNull(unitChainInfoDO.getParentId()) && NumberUtil.compare(unitChainInfoDO.getParentId(), 0) != 0) {
            Preconditions.checkArgument(paramExists(unitChainInfoDO.getParentId()), ResultCode.SC_NO_CONTENT.getMessage());
        }

        return unitChainInfoDO;
    }

    /**
     * 根据参数 查询数据
     * 列表
     *
     * @param unitChainInfoDTO
     * @return
     */
    private List<SystemUnitChainInfoDO> selectList(QuerySystemUnitChainInfoDTO unitChainInfoDTO) {

        return baseMapper.selectSystemUnitChainInfo(unitChainInfoDTO);
    }
}
