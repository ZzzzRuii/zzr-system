package com.zzr.apollo.controller;

import cn.hutool.core.util.CharsetUtil;
import com.zzr.apollo.api.R;
import com.zzr.apollo.api.ResultCode;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * WebGlobalExceptionHandler
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/29 16:09
 */
@RestControllerAdvice
public class WebGlobalExceptionHandler {
    /**
     * 拦截JSON参数校验 消息编码转换 ISO_8859_1 -> UTF_8
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R validationException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String defaultMessage = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
        return R.fail(ResultCode.PARAM_VALID_ERROR, CharsetUtil.convert(defaultMessage, CharsetUtil.ISO_8859_1, CharsetUtil.UTF_8));
    }
}
