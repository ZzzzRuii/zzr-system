package com.zzr.apollo.feign;

import com.zzr.apollo.channel.dto.CreateCmmChannelDTO;
import com.zzr.apollo.channel.dto.QueryCmmChannelDTO;
import com.zzr.apollo.channel.dto.UpdateCmmChannelDTO;
import com.zzr.apollo.channel.vo.CmmChannelVO;
import com.zzr.apollo.feign.channel.IChannelClient;
import com.zzr.apollo.service.ICmmChannelService;
import com.zzr.base.api.R;
import com.zzr.base.support.Page;
import com.zzr.base.support.Query;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * ChannelClient
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/6 17:13
 */
@Slf4j
@RestController
@AllArgsConstructor
public class ChannelClient implements IChannelClient {

    private final ICmmChannelService service;

    
    /**
     * 查询渠道 根据条件
     *
     * @param query 分页
     * @param dto
     * @return
     */
    @Override
    public R<Page<CmmChannelVO>> selectPage(Query query, QueryCmmChannelDTO dto) {
        return R.data(service.selectPage(query, dto));
    }

    /**
     * 创建渠道
     *
     * @param dto
     * @return 主订单id
     * @return
     */
    @Override
    public R<Long> create(CreateCmmChannelDTO dto) {
        return null;
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public R<CmmChannelVO> detail(Long id) {
        return null;
    }

    /**
     * 根据Id 更新 渠道对象
     *
     * @param id
     * @param dto
     * @return
     */
    @Override
    public R<Boolean> update(Long id, UpdateCmmChannelDTO dto) {
        return null;
    }

    /**
     * 根据id删除 渠道
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> delete(Long id) {
        return null;
    }

    /**
     * 根据id激活 渠道
     *
     * @param id 主键
     * @return
     */
    @Override
    public R<Boolean> activate(Long id) {
        return null;
    }

    /**
     * 根据id停用渠道
     *
     * @param id
     * @return
     */
    @Override
    public R<Boolean> inactive(Long id) {
        return null;
    }
}
