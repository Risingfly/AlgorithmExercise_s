package com.gen.leetcode.dp;

/**
 * 问题:70
 * @author Genge
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 2){
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
