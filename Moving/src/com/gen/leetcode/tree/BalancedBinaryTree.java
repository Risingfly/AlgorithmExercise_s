package com.gen.leetcode.tree;

/**
 * 问题:110
 * @author Genge
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode node){
        if (node == null){
            return 0;
        }
        int l = depth(node.left);
        int r = depth(node.right);
        return l > r ? l + 1 : r + 1;
    }
}
