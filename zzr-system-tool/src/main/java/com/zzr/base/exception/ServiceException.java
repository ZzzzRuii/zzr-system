package com.zzr.base.exception;

import cn.hutool.core.text.StrFormatter;
import com.zzr.base.api.IResultCode;

/**
 * 项目服务错误
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/13 13:37
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 2359767895161832954L;
    private final IResultCode resultCode;

    public ServiceException(IResultCode resultCode, Object... args) {
        super(StrFormatter.format(resultCode.getMessage(), args));
        this.resultCode = resultCode;
    }

    public ServiceException(IResultCode resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public Throwable doFillInStackTrace() {
        return super.fillInStackTrace();
    }

    public IResultCode getResultCode() {
        return this.resultCode;
    }
}