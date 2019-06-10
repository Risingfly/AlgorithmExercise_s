package com.gen.leetcode.tree;

/**
 * 问题:129
 * @author Genge
 */
public class SumofRootLeaf {
    public int sumNumbers(TreeNode root) {
        return getSum(root,0);
    }
    public int getSum(TreeNode root,int curSum){
        if (root == null){
            return 0;
        }
//        加上当前节点的值
        curSum = curSum * 10 + root.val;
//        左右子树为空时返回
        if (root.left == null && root.right == null){
            return curSum;
        }
        int left = getSum(root.left,curSum);
        int right = getSum(root.right,curSum);
        return left + right;
    }
}
