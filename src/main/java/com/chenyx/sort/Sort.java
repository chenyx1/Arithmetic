package com.chenyx.sort;

import com.chenyx.adapter.CompareAdapter;
import com.chenyx.compare.Compare;
import com.chenyx.factory.CompareAdapterFactory;
import com.chenyx.factory.CompareFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @desc 排序算法的基类
 * @author  chenyx
 * @date 2018-07-30
 *
 * */
public abstract class Sort<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sort.class);
    protected CompareAdapter<T> compareAdapter;//比较器

    /***
     * @desc 定义一个构造方法，用于实例化比较器实例
     * @author chenyx
     * @date 2018-07-30
     *
     * */
    public Sort(String compareName) throws Exception {
        LOGGER.info("=====================Sort Constructor begin =========================");
        this.compareAdapter = CompareAdapterFactory.createCompareAdapter(compareName);
        LOGGER.info("=====================Sort Constructor end =========================");
    }
    /***
     * @desc 定义一个构造方法，用于实例化比较器实例
     * @author chenyx
     * @date 2018-07-30
     *
     * */
    public Sort(Integer adapterType, String compareName) throws Exception {
        LOGGER.info("=====================Sort Constructor begin =========================");
        this.compareAdapter = CompareAdapterFactory.createCompareAdapter(adapterType,compareName);
        LOGGER.info("=====================Sort Constructor end =========================");
    }

    /***
     * @desc  排序算法的声明
     * @author chenyx
     * @date 2018-07-30
     * */
    public abstract T[] sort(T [] arr) throws Exception;
    /**
     * @desc 检测是否为空
     * @author chenyx
     * @date 2018-07-30
     * */
    public boolean isEmpty(T [] arr) {

        if (arr != null && arr.length > 0) {
            return false;
        }
        return true;
    }


}
