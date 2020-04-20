package com.google.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by yuxiaodong01 on 2020/04/20.
 */
public class JoinerExample {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("red", "blue", "yellow");
        Preconditions.checkNotNull(stringList);
        StringBuilder sb = Joiner.on("#").skipNulls().appendTo(new StringBuilder(), stringList);
        System.out.println(sb.toString());
    }
}
