package com.chenyx.sort;

public class InsertSort <T> extends Sort<T>  {
    public InsertSort(String compareName) throws Exception {
        super(compareName);
    }

    public InsertSort(Integer adapterType, String compareName) throws Exception {
        super(adapterType, compareName);
    }

    /**
     *  插入排序
     *
     * */
    @Override
    public T[] sort(T[] arr) throws Exception {
        if (this.isEmpty(arr)) {
            return  arr;
        }
        for (int i =1; i < arr.length; i ++) {
            for (int j = i; j > 0 ; j--) {
                boolean result = this.compareAdapter.compare(arr[j] , arr[j-1]);
                if (!result) {
                    T t = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = t;
                }
            }
        }
        return arr;
    }
}
