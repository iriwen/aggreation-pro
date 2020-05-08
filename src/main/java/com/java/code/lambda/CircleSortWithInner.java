package com.java.code.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class CircleSortWithInner {

    public static void main(String[] args) {
        CircleSortWithInner();
    }

    public static void CircleSortWithInner() {
        Circle circle1 = new Circle("hello3",3);
        Circle circle2 = new Circle("hello1",1);
        Circle circle3 = new Circle("hello4",4);
        Circle circle4 = new Circle("hello2",2);
        Circle[] circles = {circle1, circle2, circle3, circle4};
        for (Circle circle: circles) {
            System.out.println(circle.getName());
        }
        Arrays.sort(circles, new Comparator<Circle>() {

            public int compare(Circle o1, Circle o2) {
                if(o1.getNum() > o2.getNum()){
                    return 1;
                }
                else if(o1.getNum() < o2.getNum()) {
                    return -1;
                }
                else{
                    return -1;
                }
            }
        });
        System.out.println("after sort------ ");

        for (Circle circle: circles){
            System.out.println(circle.getName());
        }
    }
}
