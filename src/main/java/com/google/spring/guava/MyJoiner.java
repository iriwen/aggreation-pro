package com.google.spring.guava;

import com.google.common.base.Preconditions;

import java.util.Iterator;
import java.util.List;

/**
 * created by yuxiaodong01 on 2020/04/22.
 */
public class MyJoiner {

    private final String delimiter;

    private MyJoiner(String delimiter) {

        Preconditions.checkNotNull(delimiter);
        this.delimiter = delimiter;
    }

    public static MyJoiner withDelimiter(String delimiter) {

        MyJoiner joiner = new MyJoiner(delimiter);
        return joiner;
    }

    public String appendTo(List<String> list) {
        String sum = "";
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            sum = sum + iterator.next();
        }
        return sum;
    }

    public final String join(Iterator<String> parts) {
        StringBuilder builder = new StringBuilder();
        Preconditions.checkNotNull(builder);
        try {
            if (parts.hasNext()) {
                builder.append(parts.next());
                while (parts.hasNext()) {
                    builder.append(this.delimiter);
                    builder.append(parts.next());
                }
            }
            return builder.toString();
        } catch (Exception var4) {
            throw new AssertionError(var4);
        }
    }
}
