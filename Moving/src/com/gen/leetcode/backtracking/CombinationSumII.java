package com.gen.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 问题：40
 * @author Genge
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
//        传形参引用
        backtrack(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
    private void backtrack(List<List<Integer>> res,List<Integer> tmp,
                           int[] nums,int remain,int start){
        if (remain < 0){
            return;
        }else if (remain == 0){
            res.add(new ArrayList<>(tmp));
        }else {
            for (int i = start; i < nums.length; i++) {
//                避免重复
                if (i > start && nums[i] == nums[i - 1]){
                    continue;
                }
                tmp.add(nums[i]);
                backtrack(res,tmp,nums,remain - nums[i],i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
