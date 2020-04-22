package com.google.spring.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.List;

/**
 * 主要了解joiner类里面的封装方式
 */
public class JoinerExample {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("red", "blue", "yellow");

        Preconditions.checkNotNull(stringList);

        StringBuilder sb = Joiner.on("#").skipNulls().appendTo(new StringBuilder(), stringList);

        //System.out.println(sb.toString());

        String res = MyJoiner.withDelimiter("#").join(stringList.iterator());

        System.out.println(res);
    }
}
