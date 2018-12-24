package com.chenyx.cache;

import com.chenyx.constant.CompareAdapterType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc 适配器缓存
 * @author  cehnyx
 * @date 2018-07-30
 *
 * */
public class AdapterCache {

    private static Map<Integer,String> adapterCache = new ConcurrentHashMap();

    static  {
        adapterCache.put(CompareAdapterType.ASEC_ADAPTER.getAdapterType(),
                "com.chenyx.adapter.AsceCompareAdapter");//升序
        adapterCache.put(CompareAdapterType.DESC_ADAPTER.getAdapterType(),
                "com.chenyx.adapter.DescCompareAdapter");//降序

    }

    public static String getAdapterCache(Integer adapterType) {
        if (adapterType == null) {
            return null;
        }
        return adapterCache.get(adapterType);
    }
}
