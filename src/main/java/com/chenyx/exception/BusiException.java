package com.chenyx.exception;

/**
 * @desc 自定义异常
 * @author chenyx
 * @date 2018-07-30
 * */
public class BusiException extends  RuntimeException {

    private Integer code ;//异常编码

    public BusiException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public BusiException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public BusiException(Throwable cause, Integer code) {
        super(cause);
        this.code = code;
    }

    public BusiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
