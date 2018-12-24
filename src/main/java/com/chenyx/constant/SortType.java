package com.chenyx.constant;

import com.chenyx.sort.QuickSort;

/***
 * @desc 定义排序类型
 * @author chenyx
 * @date 2018-07-30
 * */
public enum SortType {
    BUBBLE_SORT(20001),//冒泡排序
    QUICK_SORT(20002),//快速排序
    INSERT_SORT(20003),//插入排序
    SHELL_SORT(20004),//希尔排序
    RADIX_SORT(20005),//基数排序
    MERGER_SORT(20006);//归并排序

    private Integer type;

    SortType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
