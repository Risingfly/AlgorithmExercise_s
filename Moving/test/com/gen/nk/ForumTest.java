package com.gen.nk;

import com.gen.leetcode.tree.TreeNode;

import java.util.*;

public class ForumTest {
    public int nodeNums(TreeNode node,int n){
        if (node == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        int count = 0;
        int res = 0;
        while (!stack.isEmpty()){
            int size = stack.size();
            if (++count == n){
                res = size;
                break;
            }
            for (int i = 0; i < size; i++) {
//                pop的次数正好是当前栈的大小
                TreeNode tmp = stack.pop();
                if (tmp.right != null){
                    stack.push(tmp.right);
                }
                if (tmp.left != null){
                    stack.push(tmp.left);
                }
            }
        }

        return res;
    }
    public static ArrayList<ArrayList<Integer>> getNums(int[] nums,int target){
        ArrayList<ArrayList<Integer>> res1 = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                list.add(res[0]);
                list.add(res[1]);
            }else {
                map.put(nums[i],i);
            }
            res1.add(list);
        }
        return res1;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,4,5,6,7};
//        getNums(arr,9);
        for (ArrayList list: getNums(arr,9)) {
            System.out.println(list);
        }
    }
}
