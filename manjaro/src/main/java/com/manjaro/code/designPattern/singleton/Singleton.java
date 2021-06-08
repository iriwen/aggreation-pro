package com.manjaro.code.designPattern.singleton;

/**
 * created by iriwen on 2020/05/10.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {

            synchronized (Singleton.class) {
                //加锁之后再判断是不是为空，在获得锁之前可能被其他线程实例化
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
