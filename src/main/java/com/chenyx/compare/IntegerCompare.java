package com.chenyx.compare;

public class IntegerCompare extends NumericCompare<Integer>{

    /**
     * @desc 数值类型进行比较，如果入参为包装类型，且为null值时抛出异常
     * @author chenyx
     * @date 2018-07-30
     * */
    @Override
    public int compare(Integer t1, Integer t2) throws Exception {
        int reult = t1.compareTo(t2);
        return reult;
    }
}
