package com.gen.leetcode.tree;

/**
 * 问题:235
 * @author Genge
 */
public class CommanAncestor {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0){
            root = p.val < root.val ? root.left : root.right;
        }
        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val){
//            左子树(都小于)
            return lowestCommonAncestor(root.left,p,q);
        }else if (root.val < p.val && root.val < q.val){
//            右子树(都大于)
            return lowestCommonAncestor(root.right,p,q);
        }else {
            return root;
        }
    }
    }
