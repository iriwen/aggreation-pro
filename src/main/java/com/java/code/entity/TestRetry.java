package com.java.code.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by iriwen on 2020/08/24.
 */
public class TestRetry {

    public static void main(String[] args) {

        int[] a = new int[]{10, 5, 3, 2, 6, 8, 7, 9, 1, 4};

        int[] b = Arrays.copyOfRange(a, 2, 6);// 截取索引2（包括）到索引6（不包括）的元素

        /**
         * 同方法二一样使用了asList()方法。这不是最好的，因为asList()返回的列表的大小是固定的。事实上，
         * 返回的列表不是java.util.ArrayList，而是定义在java.util.Arrays中一个私有静态类。
         * 我们知道ArrayList的实现本质上是一个数组，而asList()返回的列表是由原始数组支持的固定大小的列表。
         * 这种情况下，如果添加或删除列表中的元素，程序会抛出异常UnsupportedOperationException。
         */

        Integer[] c = new Integer[]{10, 5, 3, 2, 6, 8, 7, 9, 1, 4};

        List<Integer> integers = Arrays.asList(c);

        ArrayList<Integer> list1 = new ArrayList<Integer>(integers);

        List<Integer> list2 = new ArrayList<Integer>(b.length);

        Collections.addAll(list2, c);

        Integer[] intArr = new Integer[list2.size()];

        Integer[] resultArr = list2.toArray(intArr);

        List<Integer> collect = Stream.of(resultArr).collect(Collectors.toList());

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
