package com.gen.leetcode.dp;

/**
 * 问题：对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，
 * 定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，
 * 求出将A串变为B串所需要的最少代价。
 *给定两个字符串A和B，及它们的长度和三种操作代价，
 *请返回将A串变为B串所需要的最小代价。
 *保证两串长度均小于等于300，且三种代价值均小于等于100。
 * @author Genge
 */
public class MinCost {
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        if (n < 0 || m < 0){
            return 0;
        }
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
//        第0列
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = i * c1;
        }
//        第0行
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = i * c0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
//                i -1 == j - 1代表当前的字符串最后一个字符是否相等而非i == j
//                字符是从0开始,因此需要规划到n m
                if (A.charAt(i - 1) == B.charAt(j - 1)){
                    dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min((dp[i][j - 1] + c0),(dp[i - 1][j] + c1)));
                }else {
                    dp[i][j] = Math.min((dp[i - 1][j - 1] + c2),Math.min((dp[i][j - 1] + c0),(dp[i - 1][j] + c1)));
                }
            }
        }
        return dp[n][m];
    }

}
