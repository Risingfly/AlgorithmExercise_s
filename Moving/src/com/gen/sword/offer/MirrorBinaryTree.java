package com.gen.sword.offer;

/**
 * 问题：镜像二叉树
 * @author Genge
 */
public class MirrorBinaryTree {
    public void Mirror(TreeNode root) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null){
            Mirror(root.left);
        }
        if (root.right != null){
            Mirror(root.right);
        }
    }
}
