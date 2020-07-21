package com.java.code.leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class TreeDeep {

    public static void main(String[] args) {

        BiTree tree = new BiTree(10);

        BiTree tree1 = new BiTree(8);
        BiTree tree11 = new BiTree(6);
        BiTree tree12 = new BiTree(9);

        BiTree tree2 = new BiTree(12);
        BiTree tree22 = new BiTree(15);
        BiTree tree222 = new BiTree(18);

        tree.left = tree1;
        tree.right = tree2;

        tree1.left = tree11;
        tree1.right = tree12;

        tree2.right = tree22;
        tree22.right = tree222;
        tree222.right = new BiTree(22);

        //树的深度是5；
        int height = getTreeHeight(tree);
        int deepth = getTreeDeep(tree);

        System.out.println("tree height is :" + height);

        System.out.println("tree deep is :" + deepth);

    }

    public static int getTreeHeight(BiTree root) {

        if (null == root) {
            return 0;
        }
        ArrayDeque<BiTree> queue = new ArrayDeque<>();
        int deep = 0;
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                BiTree node = queue.removeFirst();
                if (null != node.left) {
                    queue.add(node.left);
                }
                if (null != node.right) {
                    queue.add(node.right);
                }
            }
            deep++;
        }
        return deep;
    }


    //非递归实现
    public static int getTreeDeep(BiTree root) {
        if (root == null)
            return 0;

        BiTree current = null;
        LinkedList<BiTree> queue = new LinkedList<>();
        queue.offer(root);
        int cur, last;
        int level = 0;
        while (!queue.isEmpty()) {
            cur = 0;//记录本层已经遍历的节点个数
            last = queue.size();//当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数
            while (cur < last)//当还没有遍历到本层最后一个节点时循环
            {
                current = queue.poll();//出队一个元素

                cur++;
                //把当前节点的左右节点入队（如果存在的话）
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            //每遍历完一层level+1
            level++;
        }
        return level;
    }

}
