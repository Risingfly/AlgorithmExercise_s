package com.gen.leetcode.tree;

import java.util.*;

/**
 * 问题:103
 * @author Genge
 */
public class ZigZagLevelTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()){
            List<Integer> cur = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag){
//                    left to right(利用头插和尾插来转向)
                    cur.add(node.val);
                }else {
//                    right to left
                    cur.add(0,node.val);
                }
//                队列入队顺序不变,头插尾插改变打印顺序
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(cur);
            flag = !flag;
        }
        return res;
    }
}
