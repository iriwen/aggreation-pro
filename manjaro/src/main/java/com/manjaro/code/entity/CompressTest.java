package com.manjaro.code.entity;

import java.util.LinkedList;

public class CompressTest {

    private static final ThreadLocal tl = new ThreadLocal();
    public static void main(String[] args) {


        String charStr =  "AAABBBBBCCCCCEAAAABBBB";
        char[]  chars = charStr.toCharArray();
        char  c = chars[0] ;
        int num = 1 ;
        LinkedList<String> list = new LinkedList<>();
        for(int i= 0;i < chars.length-1;i++){

            if (chars[i] ==c && chars[i+1] == c){
                num ++;
                if(i+1 == chars.length-1){
                    list.add(c+""+num);
                }
            } else if(chars[i] ==c && chars[i+1] != c){
                list.add(c+""+num);
                num =1;
                c=chars[i+1];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(item-> stringBuilder.append(item));
        System.out.println(stringBuilder.toString());

        String classPath = System.getProperty("java.class.path");
        System.out.println("classPath : " + classPath);
    }
}
