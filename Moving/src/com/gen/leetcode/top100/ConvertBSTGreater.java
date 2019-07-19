package com.gen.leetcode.top100;

import com.gen.leetcode.tree.TreeNode;

/**
 * 问题:538
 * 思路:到过来,从右向左递归
 * @author Genge
 */
public class ConvertBSTGreater {
    private TreeNode prev = null;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        helper(root);
        return root;
    }


    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.right);
        if(prev != null){
            root.val += prev.val;
        }
        prev = root;
        helper(root.left);
    }
}
