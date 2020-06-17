package com.java.code.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * created by yuxiaodong01 on 2020/06/17.
 */
public class IteratorList {

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(10, 20, 30, 40);
        ArrayList<Integer>  list  = new ArrayList<>(list1);
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {

            Integer num = iterator.next();
            iterator.remove();
            System.out.println(num);
        }
        System.out.println(iterator.hasNext());


        /*List<Student> students = new ArrayList<>();
        students.add(new Student("male"));
        students.add(new Student("female"));
        students.add(new Student("female"));
        students.add(new Student("male"));

        //遍历删除,除去男生
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if ("male".equals(student.getGender())) {
                iterator.remove();//使用迭代器的删除方法删除
            }
        }*/
    }
}
