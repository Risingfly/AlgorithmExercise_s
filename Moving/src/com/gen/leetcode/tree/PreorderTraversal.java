package com.gen.leetcode.tree;

import java.util.*;

/**
 * 问题:144
 * @author Genge
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversalRecursive(root,res);
        return res;
    }
    public void preorderTraversalRecursive(TreeNode root,List<Integer> res){
        if (root == null){
            return;
        }
        res.add(root.val);
        preorderTraversalRecursive(root.left,res);
        preorderTraversalRecursive(root.right,res);
    }
    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return res;
        }
        stack.push(root);
        TreeNode cur = null;
        while (!stack.isEmpty()){
            cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
        return res;
    }
}
