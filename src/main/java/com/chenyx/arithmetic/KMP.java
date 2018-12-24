package com.chenyx.arithmetic;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @desc KMP算法
 *@author chenyx
 * @date  2018-11-14
 * */
public class KMP {

    /**
     * kmp 算法
     * */
    public static int kmp(String desStr, String t) throws Exception {
        int result = -1;
        if (StringUtils.isEmpty(desStr) || StringUtils.isEmpty(t)) {
            return result;
        }
        char [] desChar = desStr.toCharArray();
        char [] tChar = t.toCharArray();
        int n = desStr.length();
        int m = t.length();
        int [] nx = next(t);
        int j = 0;
        int i = 0;
        while (j < m && i < n) {
            if (j == 0 || desChar[i] == tChar[j]) {
                i++;
                j++;
            } else {
                j = nx[j];
            }
        }
        if (j >= m) {
            result = i -m +1;
        }
        return  result;
    }

    /**
     * 获取next数组
     *
     * */
    private static int[] next(String t) {
        if (StringUtils.isEmpty(t)) {
            return null;
        }
        char[] ch = t.toCharArray();
        int m = ch.length;
        int i = 1;
        int j = 0;
        int[] next = new int[m];

        while (i < m) {
            if ( j == 0 || ch[i] == ch[j]) {
                i++;
                j++;
                next[i-1] = j -1;
            }else {
                j = next[i];
            }
        }
        return next;
    }

    public static  void main (String [] args) throws Exception {

       int re = kmp("qqqqqqqqfqq","fqq");
       System.out.println("rs :" + re);
    }
}
