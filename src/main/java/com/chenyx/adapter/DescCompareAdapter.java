package com.chenyx.adapter;

import com.chenyx.constant.CompareResult;

/**
 * @desc 降序序比较适配器
 * @author  chenyx
 * @date 2018-07-30
 * */
public class DescCompareAdapter<T> extends CompareAdapter<T>  {
    public DescCompareAdapter(String compareClassName) throws Exception {
        super(compareClassName);
    }

    @Override
    public boolean compare(T t1, T t2) throws Exception {
        int retult = this.compare.compare(t1 ,t2);
        if (retult < CompareResult.EQUAL_VALUE.getValue()) {
            return  true;
        }
        return false;
    }
}
