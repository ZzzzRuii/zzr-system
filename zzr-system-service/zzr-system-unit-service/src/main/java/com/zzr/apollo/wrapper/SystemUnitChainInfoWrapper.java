package com.zzr.apollo.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.zzr.apollo.model.SystemUnitChainInfoDO;
import com.zzr.apollo.tool.constants.DemoStatusCode;
import com.zzr.apollo.unit.dto.CreateSystemUnitChainInfoDTO;
import com.zzr.apollo.unit.dto.UpdateSystemUnitChainInfoDTO;
import com.zzr.apollo.unit.vo.SystemUnitChainInfoVO;
import com.zzr.base.wrapper.BaseEntityWrapper;

import java.util.Objects;

/**
 * 组织架构包装类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/29 15:55
 */
public class SystemUnitChainInfoWrapper extends BaseEntityWrapper<SystemUnitChainInfoDO, SystemUnitChainInfoVO> {

    public static SystemUnitChainInfoWrapper build() {
        return new SystemUnitChainInfoWrapper();
    }

    @Override
    public SystemUnitChainInfoVO entityVO(SystemUnitChainInfoDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, SystemUnitChainInfoVO.class));
    }

    @Override
    public SystemUnitChainInfoDO voEntity(SystemUnitChainInfoVO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, SystemUnitChainInfoDO.class));
    }

    public SystemUnitChainInfoDO dtoEntity(CreateSystemUnitChainInfoDTO entity) {
        SystemUnitChainInfoDO unit = Objects.requireNonNull(BeanUtil.copyProperties(entity, SystemUnitChainInfoDO.class));
        unit.setStatus(DemoStatusCode.INACTIVE.getCode());
        return unit;
    }

    public SystemUnitChainInfoDO dtoEntity(UpdateSystemUnitChainInfoDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, SystemUnitChainInfoDO.class));
    }
}