package com.java8.future;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * created by yuxiaodong01 on 2020/04/20.
 */
public class FutureExample01 {

    public AtomicReference reference;

    public static void main(String[] args) throws InterruptedException {

        MyCallable<String> callable = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return "error";
            }
            return "I am finished";
        };

        MyFuture<String> result = FutureExample01.submit(callable);

        System.out.println(result.get());
        System.out.println(result.get());
        System.out.println(result.get());
        //..........  上面拿不到结果
        while (!result.isDone()) {
            Thread.sleep(100);
        }

        System.out.println(result.get());

    }

    private static <T> MyFuture<T> submit(MyCallable<T> callable) {

        AtomicReference<T> reference = new AtomicReference();
        AtomicBoolean finished = new AtomicBoolean(false);
        Thread t = new Thread(() -> {
            try {
                T result = callable.action();
                reference.set(result);
                finished.set(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t.start();

        MyFuture<T> myFuture = new MyFuture() {

            @Override
            public T get() {
                return reference.get();
            }

            @Override
            public boolean isDone() {
                return finished.get();
            }
        };
        return myFuture;
    }
}

interface MyFuture<T> {

    T get();

    boolean isDone();
}

interface MyCallable<T> {

    T action();
}

