package com.chenyx.util;

import com.chenyx.constant.ExcpConstant;
import com.chenyx.exception.BusiException;

/**
 * @desc 异常工具类
 * @author chenyx
 * @date 2018-07-30
 *
 */
public class ExcpUtil {

    public static void throwExcp(Exception e) throws Exception {
        throw e;
    }

    public static void throwExcp (Integer code ,String msg) {
        throw new BusiException(msg,code);
    }

    public static void throExcp(ExcpConstant excpConstant) {
        throwExcp(excpConstant.getCode(),excpConstant.getMsg());
    }
    public static void throExcp(ExcpConstant excpConstant ,String msg) {
        throwExcp(excpConstant.getCode(),excpConstant.getMsg() + ":" + msg);
    }
}
