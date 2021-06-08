package com.java.code.lambda;

/**
 * created by iriwen on 2020/05/06.
 */
public class TestFinally {
    public static void main(String[] args) {
        TestFinally t = new TestFinally();
        int test = t.test();
        System.out.println(test);
    }

    public int test(){

        int i = 1;

        try {
            i = 2;
            return i;
        } catch (Exception e) {
            i = 3;
            return i;
        }finally {
            i = 4;
        }
    }
}
