package com.chenyx.sort;

import com.chenyx.compare.Compare;
import com.chenyx.constant.CompareResult;

/**
 * @desc 冒泡排序
 * @author chenyx
 * @date 2018-07-30
 *
 * */
public class BubbleSort<T> extends Sort<T>{

    /***
     * @desc 定义一个构造方法，用于实例化比较器实例
     * @author chenyx
     * @date 2018-07-30
     *
     * */
    public BubbleSort(String compareClassName) throws Exception {
        super(compareClassName);
    }
    /***
     * @desc 定义一个构造方法，用于实例化比较器实例
     * @author chenyx
     * @date 2018-07-30
     *
     * */
    public BubbleSort(Integer adapterType, String compareName) throws Exception {
        super(adapterType, compareName);
    }

    @Override
    public T[] sort(T[] arr) throws Exception {
        if (this.isEmpty(arr)) {
            return arr;
        }
        for (int i = 0 ; i < arr.length; i ++) {
            for (int j = 0 ; j < arr.length -i-1 ; j++) {
                boolean result = compareAdapter.compare(arr[j] ,arr[j+1]);
                if (result) {
                    T t = arr [j];
                    arr[j] = arr[j +1];
                    arr[j + 1] = t;
                }
            }
        }
        return arr;
    }

    public int[] sort(int[] arr) throws Exception {
        if (arr == null) {
            return arr;
        }
        for (int i = 0 ; i < arr.length; i ++) {
            for (int j = 0 ; j < arr.length -i-1 ; j++) {
                if (arr[j] > arr[j+1]) {
                    int t = arr [j];
                    arr[j] = arr[j +1];
                    arr[j + 1] = t;
                }
            }
        }
        return arr;
    }
}
