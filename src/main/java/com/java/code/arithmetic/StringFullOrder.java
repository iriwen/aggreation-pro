package com.java.code.arithmetic;

import java.util.Arrays;

/**
 * created by yuxiaodong01 on 2020/06/30.
 */
public class StringFullOrder {

    static String[] array = {"2", "3", "5", "8"};

    public static void main(String[] args) {
        getAllOrder(0, array.length - 1);
    }

    public static void getAllOrder(int begin, int end) {

        if (begin == end) {
            // 其中一个排列拿到了，可以进行你的处理了，比如向console打印输出。
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = begin; i <= end; i++) {
                // 交换数据
                swap(begin, i);
                getAllOrder(begin + 1, end);
                swap(i, begin);
            }
        }
    }

    public static void swap(int from, int to) {
        // 这里应该加上各种防止无效交换的情况
        // 比如位置相同，或者2个位置的数据相同
        if (from == to || array[from] == array[to]) {
            return;
        }
        String tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }
}
