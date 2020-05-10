package com.java.code.designPattern;

/**
 * created by yuxiaodong01 on 2020/05/08.
 */
public class ConcreteStrategy1 implements  Strategy {

    @Override
    public double getResult(double num) {

        return num * 0.8;
    }
}
