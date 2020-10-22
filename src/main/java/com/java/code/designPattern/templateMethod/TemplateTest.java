package com.java.code.designPattern.templateMethod;

import com.java.code.designPattern.singleton.Singleton;

import java.util.ArrayList;

/**
 * created by yuxiaodong01 on 2020/05/10.
 */
public class TemplateTest {
    public static void main(String[] args) {

        TemplateMethod mA = new PersonLiveA();

        TemplateMethod mB = new PersonLiveB();
        mA.live();
        System.out.println("--------diffrent live style---------------");
        mB.live();


        Singleton singleTon = Singleton.getInstance();

        ArrayList<String> list = new ArrayList<>();

    }
}