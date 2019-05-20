package com.gen.leetcode.dp;

/**
 * 问题：有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，
 * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 *@author Genge
 */
public class MinimumPathOfMatrix {
    public int getMin(int[][] map, int n, int m) {
        if(n <= 0 || m <= 0){
            return -1;
        }
//      dp[i][j]表示到达第i行j列的路径和最小值
        int[][] dp = new int[n][m];
        dp[0][0] = map[0][0];
//      第0行的值等于之前的每一列值累加
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }
//      第0列的值等于之前的每一行的值累加
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }
//      dp[i][j]要么由dp[i - 1][j]走到，要么由dp[i][j - 1]走到
//      即从上述最小的路线再加上map[i][j]的位置即表示当前的最小路线
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i - 1][j] < dp[i][j - 1]){
                    dp[i][j] = map[i][j] + dp[i - 1][j];
                }else {
                    dp[i][j] = map[i][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
