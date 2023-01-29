package com.zzr.apollo.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * ResultCode
 *
 * @author ZhouZhiRui
 * @since 2022/11/28 16:03
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum ResultCode implements IResultCode {
    /**
     * success
     */
    SUCCESS(200, "success"),
    /**
     * bad request
     */
    FAILURE(400, "bad request"),
    /**
     * 未找到数据
     */
    SC_NO_CONTENT(404, "未找到数据"),
    /**
     * 请求被拒绝
     */
    REQ_REJECT(403, "请求被拒绝"),
    /**
     * 服务器发生了异常，请联系管理员！
     */
    INTERNAL_SERVER_ERROR(500, "服务器发生了异常，请联系管理员！"),
    /**
     * 缺少必要的请求参数
     */
    PARAM_MISS(416, "缺少必要的请求参数"),
    /**
     * 请求参数类型错误
     */
    PARAM_TYPE_ERROR(417, "请求参数类型错误"),
    /**
     * 参数校验失败
     */
    PARAM_VALID_ERROR(418, "参数校验失败"),
    /**
     * 未知错误
     */
    UNKNOWN_ERROR(999, "未知错误");


    /**
     * code
     */
    Integer code;
    /**
     * 描述
     */
    String message;

    /**
     * 匹配 ResultCode
     *
     * @param code
     * @return
     */
    public ResultCode of(Integer code) {
        if (code == null) {
            return null;
        }
        for (ResultCode value : ResultCode.values()) {
            if (Objects.equals(value.getCode(), code)) {
                return value;
            }
        }
        log.error("未找到错误代码: {}", code);
        return UNKNOWN_ERROR;
    }
}
