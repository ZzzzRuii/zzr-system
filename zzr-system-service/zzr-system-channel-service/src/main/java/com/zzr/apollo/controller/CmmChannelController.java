package com.zzr.apollo.controller;

import com.zzr.apollo.channel.dto.CreateCmmChannelDTO;
import com.zzr.apollo.channel.dto.QueryCmmChannelDTO;
import com.zzr.apollo.channel.dto.UpdateCmmChannelDTO;
import com.zzr.apollo.channel.vo.CmmChannelVO;
import com.zzr.apollo.model.CmmChannelDO;
import com.zzr.apollo.service.ICmmChannelService;
import com.zzr.apollo.wrapper.CmmChannelWrapper;
import com.zzr.base.api.R;
import com.zzr.base.controller.BaseController;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 渠道控制器
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/28 10:19
 */
@RestController
@AllArgsConstructor
@Api(value = "渠道")
@RequestMapping("/channel")
public class CmmChannelController extends BaseController {
    private final ICmmChannelService channelService;

    /**
     * 查询!{entity} 根据条件
     *
     * @param query      分页
     * @param channelDTO
     */
    @GetMapping
    @ApiOperation(value = "查询CmmChannel列表")
    public R<Page<CmmChannelVO>> selectPage(Query query, QueryCmmChannelDTO channelDTO) {
        Page<CmmChannelVO> channelVOPage = channelService.selectPage(query, channelDTO);

        return R.data(channelVOPage);
    }

    /**
     * 创建对象CmmChannel
     *
     * @param channelDTO
     * @return 主订单id
     */
    @PostMapping
    @ApiOperation(value = "创建对象CmmChannel")
    public R<Long> create(@RequestBody @Validated CreateCmmChannelDTO channelDTO) {
        CmmChannelDO channelDO = channelService.create(channelDTO);

        return R.data(channelDO.getId());
    }

    /**
     * 详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取CmmChannel详情")
    public R<CmmChannelVO> detail(@PathVariable("id") Long id) {
        CmmChannelDO entity = channelService.detail(id);
        CmmChannelVO vo = CmmChannelWrapper.build().entityVO(entity);

        return R.data(vo);
    }


    /**
     * 根据Id 更新 CmmChannel对象
     *
     * @param id
     * @param channelDTO
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新CmmChannel")
    public R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateCmmChannelDTO channelDTO) {
        Boolean result = channelService.update(channelDTO, id);

        return R.data(result);
    }


    /**
     * 根据id删除 CmmChannel
     *
     * @param id 主键
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除CmmChannel")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        Boolean result = channelService.deleteById(id);

        return R.data(result);
    }

    /**
     * 根据id激活 CmmChannel
     *
     * @param id 主键
     */
    @PutMapping("/{id}/activate")
    @ApiOperation(value = "激活CmmChannel")
    public R<Boolean> activate(@PathVariable("id") Long id) {
        return R.data(channelService.activate(id));
    }

    /**
     * 根据id停用 CmmChannel
     *
     * @param id 主键
     */
    @PutMapping("/{id}/inactive")
    @ApiOperation(value = "根据id停用CmmChannel")
    public R<Boolean> inactive(@PathVariable("id") Long id) {
        return R.data(channelService.inactive(id));
    }

}
