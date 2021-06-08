package code.leetcode;


/**
 * 二叉树
 */
public class BiTree {

    public  BiTree left;
    public BiTree right;
    private final int val ;

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
