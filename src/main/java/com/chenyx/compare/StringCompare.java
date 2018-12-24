package com.chenyx.compare;

public class StringCompare implements Compare<String>{
    @Override
    public int compare(String t1, String t2) throws Exception {
        return t1.compareTo(t2);
    }
}
