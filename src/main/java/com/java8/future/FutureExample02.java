package com.java8.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * created by yuxiaodong01 on 2020/04/20.
 */
public class FutureExample02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> fu = executorService.submit(()->{

            try {
                Thread.sleep(10000);
                return "success";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return  "error";
            }
        });
        //阻塞住
        while(!fu.isDone()){
            Thread.sleep(100);
        }
        System.out.println(fu.get());

        //线程池需要手动关闭 否则进程不会退出
        executorService.shutdown();
    }
}
