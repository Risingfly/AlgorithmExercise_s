package com.gen.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 问题:102
 * @author Genge
 */
public class LevelTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
//            将队列中的数据都出队(同一层次)
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null){
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right != null){
                    queue.add(queue.peek().right);
                }
                list.add(queue.poll().val);
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
