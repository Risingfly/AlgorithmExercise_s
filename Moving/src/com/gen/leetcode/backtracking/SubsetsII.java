package com.gen.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 问题：90
 * @author Genge
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null){
            return res;
        }
//        排序为去重做准备
        Arrays.sort(nums);
        backtrack(res,new ArrayList<>(),nums,0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start){
        if(start > nums.length){
            return;
        }
        res.add(new ArrayList<>(tmp));
        for(int i = start;i < nums.length;i++){
//            去重，前提是该数组有序
            if(i > start && nums[i] == nums[i - 1]){
                continue;
            }
            tmp.add(nums[i]);
            backtrack(res,tmp,nums,i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
