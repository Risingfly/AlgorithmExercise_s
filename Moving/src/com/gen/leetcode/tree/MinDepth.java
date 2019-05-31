package com.gen.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题:111
 * @author Genge
 */
public class MinDepth {
    public int minDepthDFS(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = minDepthDFS(root.left);
        int right = minDepthDFS(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left,right) + 1;
    }

    public int minDepthBFS(TreeNode root){
        if (root == null){
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null){
                    return depth;
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
