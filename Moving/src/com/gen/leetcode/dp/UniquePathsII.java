package com.gen.leetcode.dp;

/**
 * 问题:63
 * @author Genge
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        行
        int m = obstacleGrid.length;
//        列
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
//        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0){
                dp[0][i] = 1;
            }else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            }else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    if (obstacleGrid[i][j - 1] == 0 && obstacleGrid[i - 1][j] == 0){
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }else if (obstacleGrid[i][j - 1] == 0){
                        dp[i][j] = dp[i][j - 1];
                    }else if (obstacleGrid[i - 1][j] == 0){
                        dp[i][j] = dp[i - 1][j];
                    }else {
                        dp[i][j] = 0;
                    }
                }


            }
        }
        return dp[m - 1][n - 1];
    }
}
