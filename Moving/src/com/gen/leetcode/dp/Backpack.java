package com.gen.leetcode.dp;

/**
 * 问题：一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，
 * 也都有自己的重量，记录在数组w中，每件物品只能选择要装入背包还是不装入背包，
 * 要求在不超过背包承重的前提下，选出物品的总价值最大。
 *给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 * @author Genge
 */
public class Backpack {
    public int maxValue(int[] w, int[] v, int n, int cap) {
        if (w == null || w.length == 0 || v == null || v.length == 0 || n < 0 || cap < 0){
            return 0;
        }
        int[][] dp = new int[n][cap + 1];
//        计算第0行，唯一的一个物品只要小于i的重量，即可放入背包，且价值为dp[0][i] = v[i]
        for (int i = 1; i <= cap; i++) {
            if (i >= w[0]){
                dp[0][i] = v[0];
            }
        }
//        第0列表示，从0 到 n种物品组成质量为0的背包价值，显然不存在，即全为0不需要计算
//        dp[i][j]表示前i件物品组成的不小于j重量的背包的最大价值
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= cap ; j++) {
//                若第i个物品不算上则，背包最大价值为前 i - 1个物品组成小于j的质量的价值，
//                若第i个物品算上则，背包的最大价值等于前i - 1个物品组成的小于j - w[i]的质量的背包价值
//                再加上第i个物品的价值v[i]
                if (j >= w[i]){
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - w[i]] + v[i]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][cap];
    }


}
