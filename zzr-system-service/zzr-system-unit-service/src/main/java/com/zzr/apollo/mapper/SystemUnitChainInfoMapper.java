package com.zzr.apollo.mapper;

import com.zzr.apollo.model.SystemUnitChainInfoDO;
import com.zzr.apollo.unit.dto.QuerySystemUnitChainInfoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 组织架构 Mapper 接口
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/29 15:49
 */
public interface SystemUnitChainInfoMapper extends ZzrMapper<SystemUnitChainInfoDO> {

    /**
     * 根据条件查询组织架构信息
     *
     * @param unitChainInfoDTO
     * @return
     */
    List<SystemUnitChainInfoDO> selectSystemUnitChainInfo(@Param("entity") QuerySystemUnitChainInfoDTO unitChainInfoDTO);

}
