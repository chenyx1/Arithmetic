package com.chenyx.compare;

/**
 * @desc 类型比较
 * @author  chneyx
 * @date 2018-07-30
 * */
public interface Compare<T> {

    /**
     * @dese 比较实现类声明
     * result ： 1 代表 t1 > t2; 0 代表 t1 = t2; -1代表t1 < t2
     * @author chenyx
     * @date 2018-07-30
     *
     * */
    int compare(T t1 ,T t2) throws Exception;
}
