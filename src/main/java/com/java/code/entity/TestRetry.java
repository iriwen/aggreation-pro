package com.java.code.entity;

/**
 * created by yuxiaodong01 on 2020/08/24.
 */
public class TestRetry {

    public static void main(String[] args) {

        int count = 0;
        retry:
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                count++;
                if (count == 3) {
                    //break retry;是跳出了整个的两层循环
                    break retry;
                }
                System.out.print(count + " ");
            }
        }
    }

}
