package com.chenyx.adapter;

import com.chenyx.compare.Compare;
import com.chenyx.factory.CompareFactory;
import com.chenyx.factory.SortFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @desc 比较结果适配器
 * @author  chenyx
 * @date 2018-07-30
 * */
public abstract class CompareAdapter<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompareAdapter.class);
    protected Compare<T> compare;

    public CompareAdapter(String compareClassName) throws Exception {
        LOGGER.info("=====================CompareAdapter Constructor begin =========================");
        this.compare = CompareFactory.createCompare(compareClassName);
        LOGGER.info("=====================CompareAdapter Constructor end =========================");
    }

    /**
     * @desc 比较结果设配方法，
     * return  :  false 失败
     *           true 成功
     * @author chenyx
     * @date 2018-07-30
     * */
    public abstract boolean compare(T t1,T t2) throws Exception;
}
