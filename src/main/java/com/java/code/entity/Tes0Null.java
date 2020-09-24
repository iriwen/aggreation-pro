package com.java.code.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * created by yuxiaodong01 on 2020/08/30.
 */
public class Tes0Null {
    public static void main(String[] args) {

        CityCategory category = new CityCategory(2);
        Integer id = category.getId();

        //category = null;

        boolean result = 0 < category.getId();
        System.out.println("result is :" + result);


        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));

        Iterator<Integer> iterator = list.iterator();


        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if (num % 2 == 0) {
                iterator.remove();
            }
        }
        //list.removeIf(num -> num % 2 == 0);
        int size = list.size();
        list.stream().forEach(item-> System.out.println("number : " + item));


        Object dss = "true";

        String resultData = dss.toString();

        boolean result2 = Boolean.parseBoolean(resultData);
        System.out.println(result2);


        Long dsd = null;
        boolean b = dsd > 0;
        System.out.println(b);


    }
}
