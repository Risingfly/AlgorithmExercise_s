package com.gen.leetcode.tree;

/**
 * 问题:230
 * @author Genge
 */
public class KthSmallersBST {
    /**
     * 记录最后结果
     */
    private static int num;
    /**
     * 统计节点遍历个数
     */
    private static int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        help(root);
        return num;
    }
    public void help(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            help(root.left);
        }
        if(--count == 0){
            num = root.val;
            return;
        }
        if(root.right != null){
            help(root.right);
        }
    }
}
