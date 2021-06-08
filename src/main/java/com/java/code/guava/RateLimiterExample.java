package com.java.code.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * created by iriwen on 2020/06/05.
 * 限流： 漏桶算法
 *
 *
 */
public class RateLimiterExample {

    //一秒钟之内只能有0.5次操作，2s之内有一次操作,以稳定的频率进行，和semaphore比较相似
    private static final RateLimiter rateLimiter = RateLimiter.create(0.5);
    private static final Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        int cpuNum = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cpuNum * 2);

        IntStream.range(0,9).forEach(i->{
            executor.submit(() -> testLimiter());
        });

        IntStream.range(0, 9).forEach(i -> {
            executor.submit(() -> testSemaphore());
        });
    }

    public static void testLimiter() {

        System.out.println(Thread.currentThread() + "  ...waiting " + rateLimiter.acquire());
    }

    public static void testSemaphore() {

        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread() + "  coming and do work ... ");
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println(Thread.currentThread() + " release semaphore !");
        }
    }
}
