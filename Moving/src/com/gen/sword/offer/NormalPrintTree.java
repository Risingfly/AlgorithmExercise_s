package com.gen.sword.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/***
 * 问题：按从左到右打印一棵二叉树
 * @author Genge
 */
public class NormalPrintTree {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null){
            return res;
        }
        int start = 0;
        int end = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        ArrayList<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            list.add(tmp.val);
            start++;
            if (tmp.left != null){
                queue.offer(tmp.left);
            }
            if (tmp.right != null){
                queue.offer(tmp.right);
            }
            if (start == end){
                start = 0;
                end = queue.size();
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }
}
