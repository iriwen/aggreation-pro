package com.manjaro.code.guava;

import java.util.stream.IntStream;

/**
 * created by iriwen on 2020/06/05.
 */
public class IntStreamTest {

    public static void main(String[] args) {
        IntStream.range(0,10).forEach(item->{
            System.out.println(item);
        });
    }
}
