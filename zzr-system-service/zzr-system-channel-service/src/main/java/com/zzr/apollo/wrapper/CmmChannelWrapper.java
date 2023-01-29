package com.zzr.apollo.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.zzr.apollo.channel.dto.CreateCmmChannelDTO;
import com.zzr.apollo.channel.dto.UpdateCmmChannelDTO;
import com.zzr.apollo.channel.vo.CmmChannelVO;
import com.zzr.apollo.model.CmmChannelDO;

import java.util.Objects;

/**
 * 渠道包装类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 16:39
 */
public class CmmChannelWrapper extends BaseEntityWrapper<CmmChannelDO, CmmChannelVO> {

    public static CmmChannelWrapper build() {
        return new CmmChannelWrapper();
    }

    @Override
    public CmmChannelVO entityVO(CmmChannelDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, CmmChannelVO.class));
    }

    @Override
    public CmmChannelDO voEntity(CmmChannelVO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, CmmChannelDO.class));
    }

    public CmmChannelDO dtoEntity(CreateCmmChannelDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, CmmChannelDO.class));
    }

    public CmmChannelDO dtoEntity(UpdateCmmChannelDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, CmmChannelDO.class));
    }
}