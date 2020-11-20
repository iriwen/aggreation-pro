package com.java.code.queue;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * created by yuxiaodong01 on 2020/11/12.
 */
@Data
public class DelayTaskItem implements Delayed {

    public String itemName;

    public Long createTime;

    public String status;

    public Long executionTime;

    public DelayTaskItem(String itemName, Long executionTime) {
        this.createTime = System.currentTimeMillis();
        this.itemName = itemName;
        this.status = "TODO";
        this.executionTime = executionTime;
    }

    /***
     * 期间会被多次调用，用于判断时间
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        long l = executionTime - LocalDateTime.now().atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli();
        //System.out.println("当前时间差 ： " + l);
        return l;
    }

    @Override
    public int compareTo(Delayed o) {
        DelayTaskItem item = (DelayTaskItem) o;
        System.out.println("compare to ... " +item);
        return this.executionTime.compareTo(item.getExecutionTime());
    }
}