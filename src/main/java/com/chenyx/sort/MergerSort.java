package com.chenyx.sort;

import java.util.Arrays;

/***
 * 归并排序
 */
public class MergerSort <T> extends Sort<T> {
    public MergerSort(String compareName) throws Exception {
        super(compareName);
    }

    public MergerSort(Integer adapterType, String compareName) throws Exception {
        super(adapterType, compareName);
    }

    /**
     * 归并排序
     * */
    @Override
    public T[] sort(T[] arr) throws Exception {
        if (isEmpty(arr)) {
            return arr;
        }
        return mergerSort(arr,0,arr.length-1);
    }

    private T[] mergerSort(T[] arr, int start,int end) throws Exception {
        System.out.println("start:" + start);
        System.out.println("end:" + end);
        if (start < end) {
            int mid = (start + end)/2;
            mergerSort(arr,start,mid);
            mergerSort(arr,mid + 1,end);
            merger(arr,start,end,mid);
        }
        return arr;
    }
    /**
     * 合并数组
     *
     * */
    private Object[] merger(T[] arr, int start,int end,int mid) throws Exception {

        if (isEmpty(arr)){
            return  arr;
        }
        Object[] c = null;
        if (start < end) {
            int n = mid;
            int m = end;
            c = new Object[end-start +1];
            int i=0;
            int j = mid +1;
            int k = 0;
            while (i <= n || j <= m){
                if (this.compareAdapter.compare(arr[j],arr[i])) {
                    c[k] = arr[i];
                    i ++;
                }else if (this.compareAdapter.compare(arr[i],arr[j])) {
                    c[k] = arr[j];
                    j++;
                }
                k ++;
            }
            //复制a数组剩下的元素
            if (i <= n) {
                for (; i < n; i ++) {
                    c [k] = arr[i];
                    k++;
                }
            }
            //复制b数组剩下的元素
            if (j <= m) {
                for (; j < m; i ++) {
                    c [k] = arr[i];
                    k++;
                }
            }
        }
        return c;
    }
}
