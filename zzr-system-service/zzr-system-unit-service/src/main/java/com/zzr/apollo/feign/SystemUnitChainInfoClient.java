package com.zzr.apollo.feign;

import cn.hutool.core.util.ObjectUtil;
import com.zzr.apollo.feign.unit.ISystemUnitChainInfoClient;
import com.zzr.apollo.model.SystemUnitChainInfoDO;
import com.zzr.apollo.service.ISystemUnitChainInfoService;
import com.zzr.apollo.unit.dto.CreateSystemUnitChainInfoDTO;
import com.zzr.apollo.unit.dto.QuerySystemUnitChainInfoDTO;
import com.zzr.apollo.unit.dto.UpdateSystemUnitChainInfoDTO;
import com.zzr.apollo.unit.vo.SystemUnitChainInfoVO;
import com.zzr.apollo.wrapper.SystemUnitChainInfoWrapper;
import com.zzr.base.api.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * SystemUnitChainInfoClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 10:59
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class SystemUnitChainInfoClient implements ISystemUnitChainInfoClient {

    private final ISystemUnitChainInfoService service;


    /**
     * 查询组织架构 根据条件
     *
     * @param dto
     * @return
     */
    @Override
    public R<List<SystemUnitChainInfoVO>> selectTree(QuerySystemUnitChainInfoDTO dto) {
        return R.data(service.selectTree(dto));
    }

    /**
     * 创建组织架构对象
     *
     * @param dto
     * @return
     */
    @Override
    public R<Long> create(CreateSystemUnitChainInfoDTO dto) {
        SystemUnitChainInfoDO entity = service.create(dto);
        return R.data(ObjectUtil.isNotNull(entity) ? entity.getId() : null);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public R<SystemUnitChainInfoVO> detail(Long id) {
        return R.data(SystemUnitChainInfoWrapper.build().entityVO(service.detail(id)));
    }

    /**
     * 根据Id 更新 组织架构 对象
     *
     * @param id
     * @param dto
     * @return
     */
    @Override
    public R<Boolean> update(Long id, UpdateSystemUnitChainInfoDTO dto) {
        return R.data(service.update(dto, id));
    }

    /**
     * 根据id删除组织架构
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> delete(Long id) {
        return R.data(service.deleteById(id));
    }

    /**
     * 根据id激活 组织架构
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> activate(Long id) {
        return R.data(service.activate(id));
    }

    /**
     * 根据id停用组织架构
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> inactivate(Long id) {
        return R.data(service.inactivate(id));
    }
}
