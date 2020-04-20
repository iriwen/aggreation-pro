package com.java8.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by yuxiaodong01 on 2020/04/20.
 */
public class FutureExample02 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(()->{

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("dsssdd");
        });
        //线程池需要手动关闭 否则进程不会退出
        executorService.shutdown();
    }
}
