package com.gen.leetcode.dp;

import java.util.Arrays;

/**
 * 问题：这是一个经典的LIS(即最长上升子序列)问题，
 * 请设计一个尽量优的解法求出序列的最长上升子序列的长度。
 * 给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。
 * @author Genge
 */
public class LongestIncreasingSubsequence {
    /**
     * 代码最简洁
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
    public int getLIS2(int[] A, int n){
        if (A == null || n <= 0){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
    public int getLIS(int[] A, int n) {
        if (A == null || n <= 0){
            return 0;
        }
//        dp[i]表示必须以A[i]结尾的情况下，A[0 ... i]的最长递增子序列长度
        int[] dp = new int[n];
        dp[0] = 1;
        //求dp[i]的值；如何选择倒数第二个数？所有比A[i]小的数中，
        //选择以某个数A[x]结尾的dp[x]最大的数，做倒数第二个数；
        for (int i = 1; i < n; i++) {
            //所有前面比A[i]小的数中，选择以某个数A[x]结尾的dp[x]最大的数，做倒数第二个数；
            int max = -1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[j] > max){
                    max = dp[j];
                }
            }
            dp[i] = max == -1 ? 1:max + 1;
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > res){
                res = dp[i];
            }
        }
        return res;
    }

}
