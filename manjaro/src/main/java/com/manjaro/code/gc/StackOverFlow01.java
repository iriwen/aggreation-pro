package com.manjaro.code.gc;

/**
 * created by iriwen on 2020/06/10.
 *
 * StackOverflow
 * <Description> StackOverflowError<br>
 */
public class StackOverFlow01 {

    private final StackOverFlow02 b;

    public StackOverFlow01() {
        b = new StackOverFlow02();
    }

    public static void main(String[] args) {
        StackOverFlow01 instance = new StackOverFlow01();
    }

    /*public void stackA() {
        b.stackB();
    }*/
}

class StackOverFlow02 {

    private final StackOverFlow01 a;

    public StackOverFlow02() {
        a = new StackOverFlow01();
    }

    /*public void stackB() {
        a.stackA();
    }*/
}
