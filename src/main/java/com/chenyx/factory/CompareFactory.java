package com.chenyx.factory;

import com.chenyx.compare.Compare;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

/***
 * @desc 创建compare工厂
 *@auhtor chenyx
 * @date 2018-07-30
 * */
public class CompareFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompareFactory.class);

    /**
     *@desc 工厂方法
     * @author chenyx
     * @date 2018-07-30
     *
     * */
    public static<T> Compare<T> createCompare(String compareName) throws Exception{
        LOGGER.info("===============createCompare begin=============================");
        LOGGER.info("className----------->" + compareName);
        Compare<T> compare = null;
        if (StringUtils.isEmpty(compareName)) {
            return  compare;
        }
        Class clazz =  Class.forName(compareName);
        compare = (Compare<T>) clazz.newInstance();
        LOGGER.info("===============createCompare end=============================");
        return compare;
    }
}
