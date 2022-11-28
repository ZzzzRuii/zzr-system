package com.zzr.base.api;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Optional;

/**
 * Result
 *
 * @author ZhouZhiRui
 * @since 2022/11/28 15:49
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(
            value = "状态码",
            required = true
    )
    private int code;
    @ApiModelProperty(
            value = "是否成功",
            required = true
    )
    private boolean success;
    @ApiModelProperty("承载数据")
    private T data;
    @ApiModelProperty(
            value = "返回消息",
            required = true
    )
    private String msg;

    private Result(IResultCode resultCode) {
        this(resultCode, null, resultCode.getMessage());
    }

    private Result(IResultCode resultCode, String msg) {
        this(resultCode, null, msg);
    }

    private Result(IResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMessage());
    }

    private Result(IResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, StrUtil.isNotBlank(msg) ? msg : resultCode.getMessage());
    }

    private Result(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.success = ResultCode.SUCCESS.code == code;
    }

    public static boolean isSuccess(@Nullable Result<?> result) {
        return Optional.ofNullable(result)
                .map(x -> ObjectUtils.nullSafeEquals(ResultCode.SUCCESS.code, x.code))
                .orElse(Boolean.FALSE);
    }

    public static boolean isNotSuccess(@Nullable Result<?> result) {
        return !isSuccess(result);
    }

    public static <T> Result<T> data(T data) {
        return data(data, "操作成功");
    }

    public static <T> Result<T> data(T data, String msg) {
        return data(200, data, msg);
    }

    public static <T> Result<T> data(int code, T data, String msg) {
        return new Result(code, data, data == null ? "暂无承载数据" : msg);
    }

    public static <T> Result<T> success(String msg) {
        return new Result(ResultCode.SUCCESS, msg);
    }

    public static <T> Result<T> success() {
        return success("");
    }

    public static <T> Result<T> success(IResultCode resultCode) {
        return new Result(resultCode);
    }

    public static <T> Result<T> success(IResultCode resultCode, String msg) {
        return new Result(resultCode, msg);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result(ResultCode.FAILURE, msg);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return new Result(code, null, msg);
    }

    public static <T> Result<T> fail(IResultCode resultCode) {
        return new Result(resultCode);
    }

    public static <T> Result<T> fail(IResultCode resultCode, String msg) {
        return new Result(resultCode, msg);
    }

    public static <T> Result<T> status(boolean flag) {
        return flag ? success("操作成功") : fail("操作失败");
    }
}
