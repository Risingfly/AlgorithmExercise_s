package com.gen.test;

import com.gen.sword.offer.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TreeTest {
    public int TreeDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left < right ? right + 1 : left + 1;
    }

    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k){
        if (pRoot != null){
            TreeNode node = KthNode(pRoot.left,k);
            if (node != null){
                return node;
            }
            index++;
            if (index == k){
                return pRoot;
            }
            node = KthNode(pRoot.right,k);
            if (node != null){
                return node;
            }
        }
        return null;
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        if (Math.abs(depath(root.left) - depath(root.right)) < 1){
            return true;
        }else {
            return false;
        }
    }

    public int depath(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = depath(node.left);
        int right = depath(node.right);
        return left > right ? left + 1 : right + 1;
    }

    int count = 0;
    private PriorityQueue<Integer> min = new PriorityQueue<>();
    private PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num){
        if (count % 2 == 0){
            max.add(num);
            int filterMax = max.poll();
            min.add(filterMax);
        }else {
            min.add(num);
            int filterMin = min.poll();
            max.add(filterMin);
        }
        count++;
    }

    public Double GetMedian(){
        if (count % 2 == 0){
            return new Double(max.peek()+min.peek()) / 2;
        }else {
            return new Double(min.peek());
        }
    }
}
