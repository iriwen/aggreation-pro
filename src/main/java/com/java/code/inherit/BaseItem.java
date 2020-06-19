package com.java.code.inherit;

/**
 * created by yuxiaodong01 on 2020/06/19.
 */

public class BaseItem implements CustomButton.AbstractDelegate {

    @Override
    public void doSomething(String v) {
        System.out.println("I do this thing : " + v);
    }
}

