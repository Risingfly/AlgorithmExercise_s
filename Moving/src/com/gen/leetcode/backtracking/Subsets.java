package com.gen.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题：78
 * @author Genge
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null){
            return res;
        }
        backtrack(res,new ArrayList<>(),nums,0);
        return res;
    }
    private void backtrack(List<List<Integer>> res,List<Integer> tmp,int[] nums,int start){
        if (start > nums.length){
            return;
        }
        res.add(new ArrayList<>(tmp));
        System.out.println(start+"res = "+tmp.toString());
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(res,tmp,nums,i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        Subsets subsets = new Subsets();
        subsets.subsets(arr);
    }
}
