package com.zzr.apollo.feign.channel;

import com.zzr.apollo.channel.dto.CreateCmmChannelDTO;
import com.zzr.apollo.channel.dto.QueryCmmChannelDTO;
import com.zzr.apollo.channel.dto.UpdateCmmChannelDTO;
import com.zzr.apollo.channel.vo.CmmChannelVO;
import com.zzr.base.api.R;
import com.zzr.base.constants.FeignConstants;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * IChannelClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/6 17:21
 */
public interface IChannelClient {

    /**
     * 查询渠道 根据条件
     *
     * @param query 分页
     * @param dto
     * @return
     */
    @GetMapping(FeignConstants.CHANNEL)
    @ApiOperation(value = "查询渠道列表")
    R<Page<CmmChannelVO>> selectPage(@SpringQueryMap Query query, @SpringQueryMap QueryCmmChannelDTO dto);

    /**
     * 创建对象渠道
     *
     * @param dto
     * @return 主订单id
     * @return
     */
    @PostMapping(FeignConstants.CHANNEL)
    @ApiOperation(value = "创建对象渠道")
    R<Long> create(@RequestBody CreateCmmChannelDTO dto);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(FeignConstants.CHANNEL + "/{id}")
    @ApiOperation(value = "根据Id获取渠道详情")
    R<CmmChannelVO> detail(@PathVariable("id") Long id);


    /**
     * 根据Id 更新 渠道对象
     *
     * @param id
     * @param dto
     * @return
     */
    @PutMapping(FeignConstants.CHANNEL + "/{id}")
    @ApiOperation(value = "更新渠道")
    R<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateCmmChannelDTO dto);


    /**
     * 根据id删除 渠道
     *
     * @param id 主键
     * @return
     */
    @DeleteMapping(FeignConstants.CHANNEL + "/{id}")
    @ApiOperation(value = "删除渠道")
    R<Boolean> delete(@PathVariable("id") Long id);

    /**
     * 根据id激活 渠道
     *
     * @param id 主键
     * @return
     */
    @PutMapping(FeignConstants.CHANNEL + "/{id}/activate")
    @ApiOperation(value = "激活渠道")
    R<Boolean> activate(@PathVariable("id") Long id);


    /**
     * 根据id停用渠道
     *
     * @param id
     * @return
     */
    @PutMapping(FeignConstants.CHANNEL + "/{id}/inactivate")
    @ApiOperation(value = "根据id停用渠道")
    R<Boolean> inactive(@PathVariable("id") Long id);
}
