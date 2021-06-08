package com.java.code.designPattern.templateMethod;

/**
 * created by iriwen on 2020/05/10.
 */
public abstract class TemplateMethod {

    //主流程方法 里面包含 1上学 2工作 3结婚 （上学和工作都用的模板中的方法 而具体的继承子类对marry都有不同的实现）
    public void live() {
        goSchool();
        work();
        marry();
    }

    void goSchool() {
        System.out.println("上小学中学和大学");
    }

    void work(){
        System.out.println("进大公司工作");
    }

    abstract void marry();
}