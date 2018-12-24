package com.chenyx.factory;

import com.chenyx.adapter.CompareAdapter;
import com.chenyx.cache.AdapterCache;
import com.chenyx.constant.CompareAdapterType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

/***
 * @desc 创建compare适配器工厂
 *@auhtor chenyx
 * @date 2018-07-30
 * */
public class CompareAdapterFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompareAdapterFactory.class);

    private static final Integer DEF_ADAPTER_TYPE = CompareAdapterType.ASEC_ADAPTER.getAdapterType();
    /**
     *@desc 工厂方法,创建默认适配器
     * @author chenyx
     * @date 2018-07-30
     *
     * */
    public static<T> CompareAdapter<T> createCompareAdapter(String compareName) throws Exception{

        //获取默认构造器名
        CompareAdapter<T> compareAdapter = createCompareAdapter(DEF_ADAPTER_TYPE,compareName);
        return compareAdapter;
    }


    /**
     *@desc 工厂方法,创建指定适配器
     * @author chenyx
     * @date 2018-07-30
     *
     * */
    public static<T> CompareAdapter<T> createCompareAdapter(Integer adapterType ,String compareName) throws Exception{
        LOGGER.info("===============CompareAdapterFactory begin=============================");
        LOGGER.info("className----------->" + compareName);
        CompareAdapter<T> compareAdapter = null;
        if (adapterType == null) {
            return compareAdapter;
        }
        //获取默认构造器名
        String compareAdapterName = AdapterCache.getAdapterCache(adapterType);
        Class clazz =  Class.forName(compareAdapterName);
        Constructor constructor = clazz.getConstructor(String.class);
        compareAdapter = (CompareAdapter<T>)constructor.newInstance(compareName);
        LOGGER.info("===============CompareAdapterFactory end=============================");
        return compareAdapter;
    }
}
