package com.chenyx.constant;

/***
 * @desc 定义设配类型
 * @author chenyx
 * @date 2018-07-30
 * */
public enum CompareAdapterType {
    ASEC_ADAPTER(10001), //升序
    DESC_ADAPTER(1002);//降序
    private Integer adapterType;//设配器类型
    CompareAdapterType(Integer adapterType) {
        this.adapterType = adapterType;
    }

    public Integer getAdapterType() {
        return adapterType;
    }
}
