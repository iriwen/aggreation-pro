package com.manjaro.code.leetcode;

public class TestNode {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        //l1.next = new ListNode(4);
        //l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(3);
        l3.next.next.next = new ListNode(4);
        l3.next.next.next.next = new ListNode(5);

        TestNode  node = new TestNode();
        node.printNode(l3);
        //ListNode rest = node.addTwoNumbers(l1, l2);
        //System.out.printf("rest :" + rest.toString());
    }

    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0, i = 0;
        while (l1 != null) {
            int node = l1.val * pow(10, i);
            sum += node;
            i++;
            l1 = l1.next;
        }

        int sum2 = 0, j = 0;
        while (l2 != null) {
            int node = l2.val * pow(10, j);
            sum2 += node;
            j++;
            l2 = l2.next;
        }
        int result = sum + sum2;

        String resultStr = result + "";
        int len = resultStr.length();
        char[] chars = resultStr.toCharArray();

        ListNode node = new ListNode(chars[len-1]-'0');

        ListNode tmp = node;

        for (int k = 1; k < len; k++) {
            tmp.next = new ListNode(chars[len-1-k]-'0');
            tmp = tmp.next;
        }
        return node;
    }

    public  int pow(int m, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= m;
        }
        return result;
    }
    public void printNode(ListNode node){

        System.out.println("node  value : " + node.getVal());
        if(node.next != null){
            printNode(node.next);
        }
    }
}
