package com.gen.sword.offer;

/***
 *
 * 问题：判断一颗二叉树是否是对称的二叉树
 * @author Genge
 */
public class SymmetricBinary {
    boolean isSymmetrical(TreeNode pRoot){
        if (pRoot == null){
            return true;
        }
       return isBoolean(pRoot.left,pRoot.right);
    }
    boolean isBoolean(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left != null && right != null){
            return left.val == right.val && isBoolean(left.left,right.right) && isBoolean(left.right,right.left);
        }
        return false;
    }
}
