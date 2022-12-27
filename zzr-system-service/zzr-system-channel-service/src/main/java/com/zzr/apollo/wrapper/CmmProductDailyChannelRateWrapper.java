package com.zzr.apollo.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.zzr.apollo.channel.dto.CreateCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.dto.UpdateCmmProductDailyChannelRateDTO;
import com.zzr.apollo.channel.vo.CmmProductDailyChannelRateVO;
import com.zzr.apollo.model.CmmProductDailyChannelRateDO;
import com.zzr.base.wrapper.BaseEntityWrapper;

import java.util.Objects;

/**
 * 每日价格包装类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 17:31
 */
public class CmmProductDailyChannelRateWrapper extends BaseEntityWrapper<CmmProductDailyChannelRateDO, CmmProductDailyChannelRateVO> {

    public static CmmProductDailyChannelRateWrapper build() {
        return new CmmProductDailyChannelRateWrapper();
    }

    @Override
    public CmmProductDailyChannelRateVO entityVO(CmmProductDailyChannelRateDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, CmmProductDailyChannelRateVO.class));
    }

    @Override
    public CmmProductDailyChannelRateDO voEntity(CmmProductDailyChannelRateVO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, CmmProductDailyChannelRateDO.class));
    }

    public CmmProductDailyChannelRateDO dtoEntity(CreateCmmProductDailyChannelRateDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, CmmProductDailyChannelRateDO.class));
    }

    public CmmProductDailyChannelRateDO dtoEntity(UpdateCmmProductDailyChannelRateDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, CmmProductDailyChannelRateDO.class));
    }

}