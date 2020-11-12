package com.java.code.queue;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * created by yuxiaodong01 on 2020/11/12.
 */
@Data
public class DelayTaskItem implements Delayed {

    public String itemName;

    public long createTime;

    public long executionTime;


    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
