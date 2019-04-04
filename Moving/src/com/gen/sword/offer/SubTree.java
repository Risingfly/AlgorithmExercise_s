package com.gen.sword.offer;

/***
 *
 * 问题：判断A树是否包含子树B
 * @author Genge
 */
public class SubTree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean res = false;
        if (root1 != null && root2 != null){
           res =  doHaveSubTree(root1,root2);
        }
        if (!res){
           res =  HasSubtree(root1.left,root2);
        }
        if (!res){
            res = HasSubtree(root1.right,root2);
        }
        return res;
    }
    public boolean doHaveSubTree(TreeNode t1, TreeNode t2){
//        递归出口 左子树为空，右子树不空false
//        右子树为空 false
//        该节点不相等 false,若相等则继续递归比较直至右子树为空，才真正相等
        if (t1 == null && t2 != null){
            return false;
        }
        if (t2 == null){
            return true;
        }
//        该节点不相等 false,若相等则继续递归比较直至右子树为空
        if (t1.val != t2.val){
            return false;
        }
        return doHaveSubTree(t1.left,t2.left) && doHaveSubTree(t1.right,t2.right);
    }
}
