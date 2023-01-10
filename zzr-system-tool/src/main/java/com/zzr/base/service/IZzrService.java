package com.zzr.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

/**
 * IZzrService
 *
 * @author ZhouZhiRui
 * @since 2022/11/28 14:45
 */
public interface IZzrService<T> extends IService<T> {
    /**
     * 更改状态
     *
     * @param ids
     * @param status
     * @return
     */
    boolean changeStatus(@NotEmpty List<Long> ids, String status);
}
