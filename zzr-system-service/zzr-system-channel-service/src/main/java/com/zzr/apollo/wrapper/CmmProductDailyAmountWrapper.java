package com.zzr.apollo.wrapper;

import cn.hutool.core.bean.BeanUtil;
import com.zzr.apollo.channel.dto.CreateCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.dto.UpdateCmmProductDailyAmountDTO;
import com.zzr.apollo.channel.vo.CmmProductDailyAmountVO;
import com.zzr.apollo.model.CmmProductDailyAmountDO;

import java.util.Objects;

/**
 * 每日库存包装类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 17:16
 */
public class CmmProductDailyAmountWrapper extends BaseEntityWrapper<CmmProductDailyAmountDO, CmmProductDailyAmountVO> {

    public static CmmProductDailyAmountWrapper build() {
        return new CmmProductDailyAmountWrapper();
    }

    @Override
    public CmmProductDailyAmountVO entityVO(CmmProductDailyAmountDO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, CmmProductDailyAmountVO.class));
    }

    @Override
    public CmmProductDailyAmountDO voEntity(CmmProductDailyAmountVO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, CmmProductDailyAmountDO.class));
    }

    public CmmProductDailyAmountDO dtoEntity(CreateCmmProductDailyAmountDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, CmmProductDailyAmountDO.class));
    }

    public CmmProductDailyAmountDO dtoEntity(UpdateCmmProductDailyAmountDTO entity) {
        return Objects.requireNonNull(BeanUtil.copyProperties(entity, CmmProductDailyAmountDO.class));
    }
}
