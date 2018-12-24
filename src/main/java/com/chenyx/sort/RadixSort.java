package com.chenyx.sort;

import java.util.Arrays;

/**
 * @desc 基数排序
 *
 * */
public class RadixSort<T> extends Sort<T> {
    public RadixSort(String compareName) throws Exception {
        super(compareName);
    }

    public RadixSort(Integer adapterType, String compareName) throws Exception {
        super(adapterType, compareName);
    }

    /**
     * 基数排序
     * */
    @Override
    public T[] sort(T[] arr) throws Exception {
        if (isEmpty(arr)) {
            return arr;
        }
        //检测其值是否为Integer和Long类型
        T t = arr[0];
        boolean rs = isTargetType(t);
        if (!rs) {
            return arr;
        }
        //查找出最大值
        T maxValue = qryMaxNum(arr);
        //计算最大值的位数
        int digit = (maxValue + "").length();
        Object [][] tomb = new Object[10][arr.length];//0-9对应的俑
        int[] count  = new int [10];//计数

        for(int i =0 ,n = 1; i < digit ; i ++, n = n *10) {
            //计算数组中的元素，对应的俑，并放在对应俑中
            for (int j = 0; j <arr.length ; j++) {
                if (arr[j] == null) {
                    continue;
                }

               long temp = Long.parseLong(arr[j] +"");//统一按照Long类型处理
               long remainder = temp /n%10;
               int re = (int) remainder;
                tomb[re][count[re]] = arr[j];
                count[re] = count[re] + 1;
            }

            //取出俑中对应的值
            int index = 0;
            for (int j = 0 ; j <tomb[0].length; j ++) {
                for (int k = 0 ; k < count[j] ; k ++) {
                     arr [index] = (T) tomb[j][k];
                     index ++;
                }
            }
            System.out.println("第" +(i+1)+ "次遍历结果：" + Arrays.toString(arr));
            //清空count数组
            for (int h = 0; h < count.length ; h ++) {
                count[h] = 0;
            }
            //清空tomb俑
            for (int h = 0; h < tomb.length ; h ++) {
               for (int g = 0 ; g < tomb[h].length; g ++) {
                   tomb[h][g] = 0;
               }
            }
        }
        return arr;
    }
    /**
     *
     * 查找出最大值
     * */
    private T qryMaxNum(T[] arr) throws Exception {
        if (isEmpty(arr)) {
            return  null;
        }
        T maxValue = arr[0];
        for (int i =1; i < arr.length; i ++) {
            if (this.compareAdapter.compare(arr[i],maxValue)) {
                maxValue =arr[i];
            }
        }
        return maxValue;
    }

    /**
     * 检测是否为Integer和Long类型
     *
     * @param t
     */
    private boolean isTargetType(T t) {
        if (t instanceof Integer) {
            return  true;
        }
        if (t instanceof Long) {
            return true;
        }
        return false;
    }
}
