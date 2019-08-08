package com.gen.leetcode.dp;

/**
 * 问题：494
 *@author Genge
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0 || S < 0){
            return 0;
        }
        return findTargetSumWays(nums,0,S);
    }
    private int findTargetSumWays(int[] nums,int start,int S){
        if (nums.length == start){
            return S == 0 ? 1 : 0;
        }
        return findTargetSumWays(nums,start + 1,S + nums[start]) +
                findTargetSumWays(nums,start + 1,S - nums[start]);
    }
}
