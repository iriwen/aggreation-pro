package com.java.code.codec;

/**
 * created by iriwen on 2021/03/19.
 */
public class OperationStr {

   public static void main(String[] args){

       String initStr = "100null|null|0001";
       //替换之后返回的字符串才是想要的结果
       String newStr = initStr.replaceAll("null", "");
       System.out.println(newStr);
   }
}
