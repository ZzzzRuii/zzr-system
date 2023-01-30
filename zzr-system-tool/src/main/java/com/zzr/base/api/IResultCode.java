package com.zzr.base.api;

import java.io.Serializable;

/**
 * IResultCode
 *
 * @author ZhouZhiRui
 * @since 2022/11/28 15:50
 */
public interface IResultCode extends Serializable {
    /**
     * 获取 返回信息
     *
     * @return
     */
    String getMessage();

    /**
     * 获取 返回Code
     *
     * @return
     */
    Integer getCode();
}
