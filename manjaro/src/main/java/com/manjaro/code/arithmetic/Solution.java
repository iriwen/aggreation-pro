package com.manjaro.code.arithmetic;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public static int[] sort(int[] arr) {
        // write code here
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length -1-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp;
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 4, 9};
        int[] clone = arr.clone();

        sort(arr);
        System.out.println(arr);
    }

    class Node {
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public Node reverseList(Node head) {
        //新链表
        Node newHead = null;
        while (head != null) {
            //先保存访问的节点的下一个节点，保存起来
            //留着下一步访问的
            Node temp = head.next;
            //每次访问的原链表节点都会成为新链表的头结点，
            //其实就是把新链表挂到访问的原链表节点的
            //后面就行了
            head.next = newHead;
            //更新新链表
            newHead = head;
            //重新赋值，继续访问
            head = temp;

        }
        String sdsd;
        //返回新链表的头元素
        return newHead;
    }


}