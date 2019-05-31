package com.gen.leetcode.tree;

/**
 * 问题:112
 * @author Genge
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        int count = sum - root.val;
        if (count == 0 && root.left == null && root.right == null){
            return true;
        }
        return hasPathSum(root.left,count) || hasPathSum(root.right,count);
    }
}
