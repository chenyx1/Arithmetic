package com.chenyx.constant;

/**
 * @desc 比较返回结果常量
 * @author  chenyx
 * @date 2018-07-30
 * */
public enum CompareResult {
    LARGER_VALUE(1),//大于
    EQUAL_VALUE(0),//等于
    LESS_VALUE(-1);//小于
    private Integer value;

    CompareResult(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
