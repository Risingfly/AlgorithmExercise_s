package com.gen.leetcode.dp;

/**
 * 问题：换零钱问题
 * dp[i][j]其中i为组成目标值的数组下标，而j直接为阶段性目标（即将aim分解，直到达到aim）
 * @author Genge
 */
public class ExchangeMoney {
    public int countWays(int[] penny, int n, int aim) {
        if (penny == null || n <= 0 || aim < 0){
            return 0;
        }
        int[][] dp = new int[n][aim + 1];
//        第0列表示组成目标0的值的方法种数，明显只有一种（即各数都为0）
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
//        第0行表示penny[0]这一种货币能够组成目标值的方法种数，只要能够被i整除，
//        则表示有一种方法可行（i为阶段目标值，是递增的直到达到真正的目标结束）
        for (int i = 1; i < (aim + 1); i++) {
            dp[0][i] = (i % penny[0] == 0) ? 1 : 0;
        }
//        从先左到右再从上到下一次计算每个阶段的i,即组成阶段性目标值的方法数dp[i][j],
//        最后，阶段行目标j --> aim, i --> n，此时即完成数组中所有可能的值组成最终目标值的
//        方法种树，dp[n - 1][aim]
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < (aim + 1); j++) {
                if (penny[i] > j){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - penny[i]];
                }
            }
        }
        return dp[n - 1][aim];
    }
}
