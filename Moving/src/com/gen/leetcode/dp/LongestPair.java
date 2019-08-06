package com.gen.leetcode.dp;

import java.util.Arrays;

/**
 * 问题：646
 * @author Genge
 */
public class LongestPair {
    public int findLongestChain(int[][] pairs){
        int n = pairs.length;
        Arrays.sort(pairs,(a,b)->{
            if (a[0] == b[0]){
                return a[1] - b[1];
            }else {
                return a[0] - b[0];
            }
        });
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
//        因为排过序，所以最后一个结尾的必定是最大
        return dp[n - 1];
    }
}
