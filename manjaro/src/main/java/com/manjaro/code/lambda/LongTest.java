package com.manjaro.code.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LongTest {
    public static void main(String[] args) {
        Long a = 7L;
        List<Long> longs = new ArrayList<Long>();
        longs.add(1L);
        longs.add(2L);
        longs.add(1L);
        longs.add(7L);
        List<Object> collect = longs.stream().filter(item -> 7 == item).collect(Collectors.toList());

        System.out.println(collect.size());
    }
}
