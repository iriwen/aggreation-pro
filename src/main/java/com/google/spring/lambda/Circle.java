package com.google.spring.lambda;

public class Circle {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Circle(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String name;
    public int num;


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
