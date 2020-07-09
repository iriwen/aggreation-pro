package com.java.code.leetcode;

public class TwoDimensionArray {


    public static void main(String[] args) {

        int[][] matrix = {
                {1, 5, 9},
                {4, 8, 15},
                {6, 11, 16},
                {7, 13, 20}
        };

        int len = matrix.length;
        int width = matrix[0].length;

        int a = len * width;

        int[] target = new int[a];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                target[i * matrix[i].length + j] = matrix[i][j];
            }
        }
        System.out.println(target);

        for (int i = 0; i < target.length; i++) {

            for (int j = 0; j < target.length - i - 1; j++) {

                if (target[j] > target[j + 1]) {
                    int tmp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = tmp;
                }
            }
        }
        System.out.println(target);
    }
}
