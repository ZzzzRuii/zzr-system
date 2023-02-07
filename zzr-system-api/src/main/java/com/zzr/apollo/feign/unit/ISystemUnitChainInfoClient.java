package com.zzr.apollo.feign.unit;

import com.zzr.apollo.unit.dto.CreateSystemUnitChainInfoDTO;
import com.zzr.apollo.unit.dto.QuerySystemUnitChainInfoDTO;
import com.zzr.apollo.unit.dto.UpdateSystemUnitChainInfoDTO;
import com.zzr.apollo.unit.vo.SystemUnitChainInfoVO;
import com.zzr.base.api.R;
import com.zzr.base.constants.FeignConstants;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ISystemUnitChainInfo
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/7 10:30
 */
public interface ISystemUnitChainInfoClient {
    /**
     * 查询组织架构 根据条件
     *
     * @param infoDTO
     * @return
     */
    @GetMapping(FeignConstants.SYSTEM_UNIT_CHAIN_INFO)
    R<List<SystemUnitChainInfoVO>> selectTree(@SpringQueryMap QuerySystemUnitChainInfoDTO infoDTO);

    /**
     * 创建组织架构对象
     *
     * @param infoDTO
     * @return
     */
    @PostMapping(FeignConstants.SYSTEM_UNIT_CHAIN_INFO)
    R<Long> create(@RequestBody CreateSystemUnitChainInfoDTO infoDTO);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(FeignConstants.SYSTEM_UNIT_CHAIN_INFO + "/{id}")
    R<SystemUnitChainInfoVO> detail(@PathVariable("id") Long id);

    /**
     * 根据Id 更新 组织架构 对象
     *
     * @param id
     * @param infoDTO
     * @return
     */
    @PutMapping(FeignConstants.SYSTEM_UNIT_CHAIN_INFO + "/{id}")
    R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateSystemUnitChainInfoDTO infoDTO);

    /**
     * 根据id删除组织架构
     *
     * @param id 主键
     * @return
     */
    @DeleteMapping(FeignConstants.SYSTEM_UNIT_CHAIN_INFO + "/{id}")
    R<Boolean> delete(@PathVariable("id") Long id);

    /**
     * 根据id激活 组织架构
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.SYSTEM_UNIT_CHAIN_INFO + "/{id}/activate")
    R<Boolean> activate(@PathVariable("id") Long id);

    /**
     * 根据id停用组织架构
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.SYSTEM_UNIT_CHAIN_INFO + "/{id}/inactivate")
    R<Boolean> inactivate(@PathVariable("id") Long id);
}
