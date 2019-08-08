package com.gen.test3;

public class TestBackPack {
    public int maxValue(int[] w, int[] v, int n, int cap){
        if (w == null || w.length == 0 || v == null || v.length == 0 || n < 0 || cap < 0){
            return 0;
        }
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j >= w[i - 1]){
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][cap];
    }
}
