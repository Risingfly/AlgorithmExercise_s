package com.gen.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 问题：39
 * @author Genge
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res,new ArrayList<>(),nums,target,0);
        return res;
    }
    private void backtrack(List<List<Integer>> res,List<Integer> tmp,int[] nums,int remain,int start){
        if (remain < 0){
            return;
        }else if (remain == 0){
            res.add(new ArrayList<>(tmp));
        }else {
            for (int i = start; i < nums.length; i++) {
                tmp.add(nums[i]);
                backtrack(res,tmp,nums,remain - nums[i],i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
