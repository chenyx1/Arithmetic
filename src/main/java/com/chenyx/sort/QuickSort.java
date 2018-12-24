package com.chenyx.sort;

import com.chenyx.adapter.CompareAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickSort<T> extends Sort<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuickSort.class);

    public QuickSort(String compareName) throws Exception {
        super(compareName);
    }

    public QuickSort(Integer adapterType, String compareName) throws Exception {
        super(adapterType, compareName);
    }

    //快速排序
    @Override
    public T[] sort(T[] arr) throws Exception {
        if (this.isEmpty(arr)) {
            return arr;
        }
        return quickSort(arr,0,arr.length-1);
    }

    /**
     * 快速排序
     *
     * */
    public T[] quickSort(T[] arr, int start,int end) throws Exception {
        if (this.isEmpty(arr)) {
            return arr;
        }
        if (start >= end) {
            return arr;
        }
        T t = arr[start];
        int hight = end;
        int low = start;
        T temp = t;
        while (low < hight) {
            //高位大于标准位，递减
            while (!this.compareAdapter.compare(t,arr[hight]) && low < hight){
               hight --;
            }
            temp = arr[hight];
            arr[hight] =  arr[low];
            arr[low] = temp;
            //低位小于高位，递加
            while (!this.compareAdapter.compare(arr[low],t) && low < hight) {
                low ++;
            }
            temp = arr[low];
            arr[low] = arr[hight];
            arr[hight] = temp;
        }
        arr = quickSort( arr, start,hight-1);
        arr = quickSort( arr, low + 1,end);
        return arr;
    }
}
