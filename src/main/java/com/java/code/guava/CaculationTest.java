package com.java.code.guava;

/**
 * created by yuxiaodong01 on 2020/04/15.
 */
public class CaculationTest {

    public static void main(String[] args) {
        //按位与，运算符两边的数值会先替换成二进制，然后再对比进行运算
        int a = 3;
        int b = 5;
        System.out.println("3 & 5 =  " + (a & b));
        System.out.println("5 & 7 =  " + (5 & 7));
        reverse();
    }

    public static void bitOr() {
        //按位或和&按位与计算方式都是转换二进制再计算，不同的是运算规则(一个为真即为真)1|0 = 1 , 1|1 = 1 , 0|0 = 0 , 0|1 = 1
        int a = 2;
        int b = 6;
        System.out.println("6|2 : " + (a | b));
    }

    public static void diffOr() {
        //^异或运算符顾名思义，异就是不同(不同为1，相同为0)，其运算规则为1^0 = 1 , 1^1 = 0 , 0^1 = 1 , 0^0 = 0
        int i = 5 ^ 9;
        System.out.println("5 异或 9结果：" + i);
    }

    public static int moveLeft() {
        /*5<<2的意思为5的二进制位往左挪两位，右边补0，5的二进制位是0000 0101 ， 就是把有效值101往左挪两位就是0001 0100 ，
        正数左边第一位补0，负数补1，等于乘于2的n次方，十进制位是20*/
        int result = 5 << 3;
        System.out.println("5的二进制左移3位，结果： " + result);
        return 0;
    }

    public static void moveRight() {
        /*凡位运算符都是把值先转换成二进制再进行后续的处理，10的二进制位是0000 1010，右移三位就是把1010右边移后为0000 0001，
        正数左边第一位补0，负数补1，等于除于2的n次方，结果为1*/
        int result = 10 >> 3;
        System.out.println("10 右移3位结果：" + result);
    }

    public static void reverse(){
        //取反就是1为0,0为1,5的二进制位是0000 0101，取反后为1111 1010，值为-6
        int res = ~5;
        System.out.printf("5取反运算：" + res);
    }

}

