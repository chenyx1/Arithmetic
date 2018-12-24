package com.chenyx.constant;

/**
 * @desc 定义异常常量信息
 * @author chenyx
 * @date 2018-07-30
 * */
public enum ExcpConstant {

    UNKNOW_EXCP(-1,"未知异常"),//未知异常
    SYSTEM_EXCP(-2,"系统内部异常"),//系统内部异常
    RUN_EXCP(-3,"运行异常");//运行异常
    
    private Integer code;//异常编码
    private String msg;//异常信息

    ExcpConstant(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
