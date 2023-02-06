package com.zzr.base.handler;

import com.zzr.base.api.IResultCode;
import com.zzr.base.api.R;
import com.zzr.base.api.ResultCode;
import com.zzr.base.exception.ServiceException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * 全局异常处理器
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/29 16:09
 */
@RestControllerAdvice
public class WebGlobalExceptionHandler {
    /**
     * 拦截JSON参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R validationException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String defaultMessage = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
        return R.fail(ResultCode.PARAM_VALID_ERROR, defaultMessage);
    }

    /**
     * 拦截Service服务异常
     */
    @ExceptionHandler(Exception.class)
    public R serviceException(Exception e) {
        if (e instanceof ServiceException) {
            IResultCode resultCode = ((ServiceException) e).getResultCode();
            return R.fail(resultCode);
        }
        return R.fail(ResultCode.UNKNOWN_ERROR, e.getMessage());
    }
}
