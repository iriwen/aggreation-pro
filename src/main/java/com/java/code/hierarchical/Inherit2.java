package com.java.code.hierarchical;

/**
 * created by yuxiaodong01 on 2021/05/26.
 */
public abstract class Inherit2 implements  Inherit1{

    @Override
    public void method(){
        System.out.println("invoke method in Inherit2");
        init();
    }

    public void init(){
        System.out.println("init in Inherit2");
    }

}
