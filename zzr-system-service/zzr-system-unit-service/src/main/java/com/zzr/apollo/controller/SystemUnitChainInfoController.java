package com.zzr.apollo.controller;

import com.zzr.apollo.model.SystemUnitChainInfoDO;
import com.zzr.apollo.service.ISystemUnitChainInfoService;
import com.zzr.apollo.unit.dto.CreateSystemUnitChainInfoDTO;
import com.zzr.apollo.unit.dto.QuerySystemUnitChainInfoDTO;
import com.zzr.apollo.unit.dto.UpdateSystemUnitChainInfoDTO;
import com.zzr.apollo.unit.vo.SystemUnitChainInfoVO;
import com.zzr.apollo.wrapper.SystemUnitChainInfoWrapper;
import com.zzr.base.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 组织结构控制器
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/9 17:23
 */
@RestController
@AllArgsConstructor
@Api(value = "组织架构")
@RequestMapping("/unit")
public class SystemUnitChainInfoController {

    private final ISystemUnitChainInfoService unitChainInfoService;

    /**
     * 查询!{entity} 根据条件
     *
     * @param infoDTO
     * @return
     */
    @GetMapping
    @ApiOperation(value = "查询SystemUnitChainInfo列表")
    public R<List<SystemUnitChainInfoVO>> selectTree(QuerySystemUnitChainInfoDTO infoDTO) {

        return R.data(unitChainInfoService.selectTree(infoDTO));
    }

    /**
     * 创建SystemUnitChainInfo对象
     *
     * @param infoDTO
     * @return
     */
    @PostMapping
    @ApiOperation(value = "创建SystemUnitChainInfo对象")
    public R<Long> create(@RequestBody @Validated CreateSystemUnitChainInfoDTO infoDTO) {
        SystemUnitChainInfoDO infoDO = unitChainInfoService.create(infoDTO);

        return R.data(infoDO.getId());
    }

    /**
     * 详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取SystemUnitChainInfo详情")
    public R<SystemUnitChainInfoVO> detail(@PathVariable("id") Long id) {
        SystemUnitChainInfoDO entity = unitChainInfoService.detail(id);
        SystemUnitChainInfoVO vo = SystemUnitChainInfoWrapper.build().entityVO(entity);

        return R.data(vo);
    }


    /**
     * 根据Id 更新 SystemUnitChainInfo对象
     *
     * @param id
     * @param infoDTO
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新SystemUnitChainInfo")
    public R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateSystemUnitChainInfoDTO infoDTO) {
        Boolean result = unitChainInfoService.update(infoDTO, id);

        return R.data(result);
    }


    /**
     * 根据id删除SystemUnitChainInfo
     *
     * @param id 主键
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除SystemUnitChainInfo")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        Boolean result = unitChainInfoService.deleteById(id);

        return R.data(result);
    }

    /**
     * 根据id起草SystemUnitChainInfo
     *
     * @param id 主键
     */
    @PutMapping("/{id}/draft")
    @ApiOperation(value = "起草SystemUnitChainInfo")
    public R<Boolean> draft(@PathVariable("id") Long id) {
        return R.data(unitChainInfoService.draft(id));
    }

    /**
     * 根据id存档SystemUnitChainInfo
     *
     * @param id 主键
     */
    @PutMapping("/{id}/archived")
    @ApiOperation(value = "根据id存档SystemUnitChainInfo")
    public R<Boolean> archived(@PathVariable("id") Long id) {
        return R.data(unitChainInfoService.archived(id));
    }

    /**
     * 根据id发布SystemUnitChainInfo
     *
     * @param id 主键
     */
    @PutMapping("/{id}/published")
    @ApiOperation(value = "根据id发布SystemUnitChainInfo")
    public R<Boolean> published(@PathVariable("id") Long id) {
        return R.data(unitChainInfoService.published(id));
    }

}