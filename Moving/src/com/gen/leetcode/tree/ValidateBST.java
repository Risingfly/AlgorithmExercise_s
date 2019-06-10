package com.gen.leetcode.tree;

/**
 * 问题:98
 * @author Genge
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long minval,long maxval){
        if (root == null){
            return true;
        }
        if (root.val <= minval || root.val >= maxval){
            return false;
        }
        return isValidBST(root.left,minval,root.val) && isValidBST(root.right,root.val,maxval);
    }

}
