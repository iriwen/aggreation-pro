package com.java.code.future;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * created by iriwen on 2020/04/20.
 */
public class FutureExample03 {

    public static void main(String[] args) {

        ListenableFuture<String> listenFuture = FutureExample03.invoke(() -> {
            Thread.sleep(10000);
            return "I am finished !";
        });

        listenFuture.addListener(new Completable<String>() {
            //到时异步回调
            @Override
            public void complete(String result) {
                System.out.println("complete result ：" + result);
            }

            @Override
            public void exception(Throwable cause) {
                System.out.println("error");
                cause.printStackTrace();
            }
        });

        System.out.println("........");
        System.out.println("忙点别的：" + listenFuture.get());
        System.out.println("看下有没有结果 ：" + listenFuture.get());
    }

    public static <T> ListenableFuture<T> invoke(Callable<T> callable) {

        AtomicReference<T> reference = new AtomicReference<>();

        AtomicBoolean isDone = new AtomicBoolean(false);

        ListenableFuture future = new ListenableFuture() {

            private Completable<T> completable;

            @Override
            public T get() {
                return reference.get();
            }

            @Override
            public boolean isDone() {
                return isDone.get();
            }

            @Override
            public void addListener(Completable completable) {

                this.completable = completable;
            }

            @Override
            public Completable<T> getCompletable() {
                return this.completable;
            }

        };

        Thread thread = new Thread(() -> {

            T result = null;
            try {
                result = callable.call();
                reference.set(result);
                isDone.set(true);
                if (future.getCompletable() != null) {
                    future.getCompletable().complete(result);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (future.getCompletable() != null) {
                    future.getCompletable().exception(e);
                }
            }
        });

        thread.start();

        return future;
    }

    private interface ListenableFuture<T> {

        T get();

        boolean isDone();

        void addListener(Completable<T> completable);

        Completable<T> getCompletable();
    }

    private interface Completable<T> {
        void complete(T t);

        void exception(Throwable cause);
    }
}
