package com.java.code.entity;

import java.util.Arrays;

/**
 * created by yuxiaodong01 on 2020/08/24.
 */
public class TestRetry {

    public static void main(String[] args) {

        int[] a = new int[] { 10, 5, 3, 2, 6, 8, 7, 9, 1, 4 };

        int[] b = Arrays.copyOfRange(a, 2, 6);// 截取索引2（包括）到索引6（不包括）的元素
        int count = 0;
        retry:
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                count++;
                if (count == 3) {
                    //break retry;是跳出了整个的两层循环,这里不一定要是retry也可以是hello 等其他单词
                    break retry;
                }
                System.out.print(count + " ");
            }
        }
    }

}
