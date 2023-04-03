package com.zzr.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzr.base.model.entity.BaseDO;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * ZzrMapper
 *
 * @author ZhouZhiRui
 * @since 2022/11/28 17:49
 */
public interface ZzrMapper<T extends BaseDO> extends BaseMapper<T> {
    /**
     * 更改状态
     *
     * @param ids
     * @param status
     * @return
     */
    boolean changeStatus(@NotEmpty List<Long> ids, String status);
}
