package com.gen.leetcode.dp;

import java.util.Arrays;

/**
 * 问题：416
 * @author Genge
 */
public class PartitionEqualSum {
    public boolean canPartition(int[] nums){
        if (nums == null || nums.length == 0){
            return false;
        }
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if ((sum & 1) == 1){
            return false;
        }
        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i],false);
        }
        dp[0][0] = true;
        for (int i = 1; i <= n ; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= sum ; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= sum ; j++) {
                if (j < nums[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
