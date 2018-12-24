package com.chenyx.cache;

import com.chenyx.constant.CompareAdapterType;
import com.chenyx.constant.SortType;
import com.chenyx.sort.Sort;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc 排序器缓存
 * @author  cehnyx
 * @date 2018-07-30
 *
 * */
public class SortCache {
    private static Map<Integer,String> sortCache = new ConcurrentHashMap();

    static  {
        sortCache.put(SortType.BUBBLE_SORT.getType(),
                "com.chenyx.sort.BubbleSort");//冒泡排序
        sortCache.put(SortType.QUICK_SORT.getType(),
                "com.chenyx.sort.QuickSort");//快速排序
        sortCache.put(SortType.INSERT_SORT.getType(),
                "com.chenyx.sort.InsertSort");//插入排序
        sortCache.put(SortType.SHELL_SORT.getType(),
                "com.chenyx.sort.ShellSort");//希尔排序
        sortCache.put(SortType.RADIX_SORT.getType(),
                "com.chenyx.sort.RadixSort");//基数排序
        sortCache.put(SortType.MERGER_SORT.getType(),
                "com.chenyx.sort.MergerSort");//归并排序
    }

    public static String getSortCache(Integer sortType) {
        if (sortType == null) {
            return null;
        }
        return sortCache.get(sortType);
    }
}
