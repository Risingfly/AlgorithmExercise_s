package com.gen.leetcode.top100;

import java.util.Arrays;

/**
 * 问题：198
 * @author Genge
 */
public class HouseRobber {
    int[] map;
    public int rob(int[] nums) {
        map = new int[nums.length + 1];
        Arrays.fill(map,-1);
        return rob(nums,nums.length - 1);
    }
    private int rob(int[] nums, int i){
        if (i < 0){
            return 0;
        }
        if (map[i] > -1){
            return map[i];
        }
        int res = Math.max(rob(nums,i - 2) + nums[i],rob(nums,i - 1));
        map[i] = res;
        return res;
    }
    public int robber(int[] nums){
        if (nums == null){
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i],dp[i - 1] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
