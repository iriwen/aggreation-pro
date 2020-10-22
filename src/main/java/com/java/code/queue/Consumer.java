package com.java.code.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * created by yuxiaodong01 on 2020/10/22.
 */
public class Consumer {

    private static final ScheduledExecutorService executors = Executors.newScheduledThreadPool(1);
    private int id;
    private BlockingQueue<String> queue;

    public Consumer() {
    }

    public Consumer(BlockingQueue<String> queue, int id) {
        this.id = id;
        this.queue = queue;
        System.out.println("创建了消费者：" + id + "号");
        //consumer();
    }

    public static void main(String[] args) {

        LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>(1000);
        Producer producer = new Producer(1, queue);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            producer.produce("@" + i + "@");
        }

        Consumer consumer = new Consumer(queue, 1);
        consumer.consume();
    }

    public void consume() {

        executors.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("消费者手里的线程池核武器收到了一个命令，此时队列中的任务数" + queue.size() + "个");
                try {
                    String message = queue.take();
                    System.out.println("消费者： " + id + "号，开始消费了");
                    Thread.sleep(3000);
                    System.out.println("消费者： " + id + "消费结束了，" + message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

}
