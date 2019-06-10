package com.gen.leetcode.tree;

/**
 * 问题:236
 * @author Genge
 */
public class BinaryTreeLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
//        左右子树不为空,则根节点为公共节点
//        递归处理完左右子树后,再回到当前层逻辑处理合并结果
        if (left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
}
