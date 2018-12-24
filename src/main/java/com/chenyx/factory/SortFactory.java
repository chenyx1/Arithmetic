package com.chenyx.factory;

import com.chenyx.cache.SortCache;
import com.chenyx.compare.Compare;
import com.chenyx.sort.Sort;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

/**
 *@desc 排序器工厂类
 * @author  chenyx
 * @date 2018-07-30
 * */
public class SortFactory<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortFactory.class);

    /**
     *@desc 工厂方法
     * @author chenyx
     * @date 2018-07-30
     *
     * */
    public static<T> Sort<T> createCompare(Integer sortType,Class comapreClazz) throws Exception{
        LOGGER.info("===============createSort begin=============================");
        LOGGER.info("className----------->" + sortType);
        Sort<T> sort = null;
        if (sortType == null) {
            return  sort;
        }
        String sortClassName = SortCache.getSortCache(sortType);
        String compareClassName = comapreClazz.getName();
        LOGGER.info("compareClassName------->" + compareClassName);
        Class clazz = Class.forName(sortClassName);
        Constructor constructor =  clazz.getConstructor(String.class);
        sort = (Sort<T>) constructor.newInstance(compareClassName);
        LOGGER.info("===============createSort end=============================");
        return sort;
    }


    /**
     *@desc 工厂方法
     * @author chenyx
     * @date 2018-07-30
     *
     * */
    public static<T> Sort<T> createCompare(Integer sortType,Integer adapterType ,Class comapreClazz) throws Exception{
        LOGGER.info("===============createSort begin=============================");
        LOGGER.info("className----------->" + sortType);
        Sort<T> sort = null;
        if (sortType == null) {
            return  sort;
        }
        String sortClassName = SortCache.getSortCache(sortType);
        String compareClassName = comapreClazz.getName();
        LOGGER.info("compareClassName------->" + compareClassName);
        Class clazz = Class.forName(sortClassName);
        Constructor constructor =  clazz.getConstructor(Integer.class ,String.class);
        sort = (Sort<T>) constructor.newInstance(adapterType,compareClassName);
        LOGGER.info("===============createSort end=============================");
        return sort;
    }
}
