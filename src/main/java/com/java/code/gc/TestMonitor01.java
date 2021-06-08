package com.java.code.gc;

/**
 * created by iriwen on 2020/06/09.
 */
public class TestMonitor01 {

    public static void main(String[] args) throws Exception {

        TestMonitor01 lock1 = new TestMonitor01();
        TestMonitor01 lock2 = new TestMonitor01();

        new Thread(() -> {

            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() + ", I have get the lock1");
                try {
                    Thread.sleep(3000000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName() + ", I have get the lock2");
                }
            }
        }).start();

        new Thread(() -> {

            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() + ", I have get the lock2");
                try {
                    Thread.sleep(3000000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName() + ", I have get the lock1");
                }
            }
        }).start();
    }
}
