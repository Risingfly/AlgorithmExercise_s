package com.gen.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 问题:145
 * @author Genge
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root,res);
        return res;
    }
    public void postorderTraversal(TreeNode root,List<Integer> res){
       if (root == null){
           return;
       }
       postorderTraversal(root.left,res);
       postorderTraversal(root.right,res);
       res.add(root.val);
    }
    public List<Integer> postorderTraversal2(TreeNode root){
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
//            头插法,先插入的数据在链表后面
            res.addFirst(cur.val);
            if (cur.left != null){
                stack.push(cur.left);
            }
            if (cur.right != null){
                stack.push(cur.right);
            }
        }
        return res;
    }
}
