package com.gen.sword.offer;

/***
 * 问题：判断平衡二叉树
 * @author Genge
 */
public class BalanceBinaryTree {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        if (Math.abs(getHigh(root.left) - getHigh(root.right)) <= 1 ){
            return true;
        }else {
            return false;
        }
    }
    public int getHigh(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = getHigh(root.left);
        int right = getHigh(root.right);
        return left < right ? right + 1 : left + 1;
    }
}
