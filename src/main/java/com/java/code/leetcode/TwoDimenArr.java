package com.java.code.leetcode;

public class TwoDimenArr {

    public static void main(String[] args) {
        int[][] arr = new int[3][4];
        //循环给二维数组赋值
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i * arr[i].length + j;
            }
        }

        //打印下二维数组
        System.out.println("---转置前---");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


        //定义一个新数组，用来存储转置后的数据
        int[][] arrNew = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arrNew[j][i] = arr[i][j];
            }
        }
        System.out.println("---转置后---");
        for (int i = 0; i < arrNew.length; i++) {
            for (int j = 0; j < arrNew[i].length; j++) {
                System.out.print(arrNew[i][j] + " ");
            }
            System.out.println();
        }


        int[][] a = new int[arr.length][arrNew[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                a[i][j] = getSum(arr[i], arr[j]);
            }
        }


        System.out.println("---result ---");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int getSum(int[] arr, int[] res){
        int sum = 0;
        for(int i = 0 ;i< arr.length;i++){
            sum+= arr[i] * res[i];
        }
        return sum;
    }


}
