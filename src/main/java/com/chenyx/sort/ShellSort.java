package com.chenyx.sort;

public class ShellSort <T> extends Sort<T>{
    public ShellSort(String compareName) throws Exception {
        super(compareName);
    }

    public ShellSort(Integer adapterType, String compareName) throws Exception {
        super(adapterType, compareName);
    }

    /**
     * 希尔排序,希尔排序是插入排序的优化
     *
     * */
    @Override
    public T[] sort(T[] arr) throws Exception {
        if (this.isEmpty(arr)) {
            return arr;
        }
        int d = arr.length/2;//维度
        while (d >=1) {
            for (int i = 0 +d ; i < arr.length; i ++ ){
                for (int j = i ; j -d >= 0 ; j = j-d) {
                    boolean result = this.compareAdapter.compare(arr[j] , arr[j-d]);
                    if (!result) {
                        T t = arr[j];
                        arr[j] = arr[j-d];
                        arr[j-d] = t;
                    }
                }
            }
            d = d/ 2;
        }
        return arr;
    }
}
