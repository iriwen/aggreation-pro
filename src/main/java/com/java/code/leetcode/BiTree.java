package com.java.code.leetcode;


/**
 * 二叉树
 */
public class BiTree {

    public  BiTree left;
    public BiTree right;
    private int val ;

    public BiTree(int val) {
        this.val = val;
    }

    public BiTree getLeft() {
        return left;
    }

    public void setLeft(BiTree left) {
        this.left = left;
    }

    public BiTree getRight() {
        return right;
    }

    public void setRight(BiTree right) {
        this.right = right;
    }
}
