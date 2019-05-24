package com.gen.leetcode.dp;

/**
 * 问题:64
 * @author Genge
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
//        row
        int n = grid.length;
//        column
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
//        first row
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
//        first column
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i - 1][j] > dp[i][j - 1]){
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                }else {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
