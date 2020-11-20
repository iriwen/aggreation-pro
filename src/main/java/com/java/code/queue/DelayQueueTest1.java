package com.java.code.queue;

import com.java.code.util.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by yuxiaodong01 on 2020/11/12.
 */
@Service
public class DelayQueueTest1 {
    public static final DelayQueue<DelayTaskItem> delayTaskQueue = new DelayQueue<>();
    private static final Logger logger = LoggerFactory.getLogger(DelayQueueTest1.class);

    public DelayQueueTest1() {
        //delayTaskQueue = new DelayQueue<>();
        Executors.newSingleThreadExecutor().submit(() -> {
            while (true) {
                processTask(delayTaskQueue);
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {

        LocalDateTime now = LocalDateTime.now();
        logger.info("current time mill :{} ", now.toInstant(ZoneOffset.of("+8")).toEpochMilli());

        long epochMill1 = now.plusMinutes(1).toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long epochMill2 = now.plusMinutes(2).toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long epochMill3 = now.plusMinutes(3).toInstant(ZoneOffset.of("+8")).toEpochMilli();
        DelayTaskItem item1 = new DelayTaskItem("task-1", epochMill1);
        DelayTaskItem item2 = new DelayTaskItem("task-2", epochMill2);
        DelayTaskItem item3 = new DelayTaskItem("task-3", epochMill3);
        List<DelayTaskItem> taskItems = Stream.of(item1, item2, item3).collect(Collectors.toList());

        //delayTaskQueue.addAll(taskItems);
        while (delayTaskQueue.isEmpty()) {
            //logger.info("empty");
            //processTask(delayTaskQueue);
        }
        //Thread.sleep(10*60000);
    }

    public void processTask(DelayQueue<DelayTaskItem> queue) {
        logger.info("check queue item ..... ");
        try {
            DelayTaskItem item = queue.take();
            CompletableFuture.runAsync(() -> {
                logger.info("开始处理任务...." + item.getItemName());
                try {
                    Thread.sleep(1000 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info(JsonMapper.toJsonString(item));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addDelayTask(DelayTaskItem item) {
        boolean res = DelayQueueTest1.delayTaskQueue.add(item);
        return res;
    }
}
