package com.gen.leetcode.dp;

/**
 * 问题:62
 * @author Genge
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0){
            return 0;
        }
        int[][] dp = new int[m][n];
//        一步也不走的方法数为1
        dp[0][0] = 1;
//        只向下走的方法数只有1种
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
//        只向右走的方法数只有1种
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
//        dp[i][j]表示到达i j 位置的方法种数
//        显然要么由dp[i - 1][j]上到下到达,要么由dp[i][j - 1]左到右到达
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
