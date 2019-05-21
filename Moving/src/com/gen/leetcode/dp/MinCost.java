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
//        dp[i][j]表示A编辑成B的最小代价，其中i= 0 | j = 0表示空串相关的操作
//        因此需要多开辟一个空间来计算空串相关的操作，故 n + 1,m + 1
        int[][] dp = new int[n + 1][m + 1];
//
//        A[0...i]编辑成B[]空串的代价，即删除A中所有字符
        for (int i = 0; i <= n ; i++) {
            dp[i][0] = c1 * i;
        }
//        A[]编辑成B[0...i]的代价，即A插入对应的字符
        for (int i = 0; i <= m; i++) {
            dp[0][i] = c0 * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(i - 1)){
//                    若对应的A和B最后（当前）一个字符相等，
//                    只需从i-1 和 j - 1调整即可，代价和之前的相等
//                    都是从插入 删除 替换这三种代价中选出最小的代价为dp[i][j]
                    dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j] +c1,
                            dp[i][j - 1] + c0));
                }else {
//                    若对应的A和B最后（当前）一个字符不相等，
//                    则需将之前的调整再加上最后一个字符的代价
//                    都是从插入 删除 替换这三种代价中选出最小的代价为dp[i][j]
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + c2,Math.min(dp[i - 1][j] +c1,
                            dp[i][j - 1] + c0));
                }
            }
        }
        return dp[n][m];
    }
}
