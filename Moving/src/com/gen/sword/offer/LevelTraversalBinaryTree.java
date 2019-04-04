package com.gen.sword.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/***
 *
 * 问题：
 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author Genge
 */
public class LevelTraversalBinaryTree {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            list.add(tmp.val);
            if (tmp.left != null){
                queue.offer(tmp.left);
            }
            if (tmp.right != null){
                queue.offer(tmp.right);
            }
        }
        return list;
    }
}
