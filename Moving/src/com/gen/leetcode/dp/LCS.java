package com.gen.leetcode.dp;

/**
 *给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。
 * 例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 *给定两个字符串A和B，同时给定两个串的长度n和m，
 *请返回最长公共子序列的长度。保证两串长度均小于等于300。
 * @author Genge
 */
public class LCS {
    public int findLCS(String A, int n, String B, int m) {
        if (n <= 0 || m <= 0){
            return 0;
        }
//        dp[i][j]表示A和B在{0..i}和{0..j}字符串长度的情况下，最长公共子序列的长度
        int[][] dp = new int[n][m];
        if (A.charAt(0) == B.charAt(0)){
            dp[0][0] = 1;
        }
//        第0列，A{0 ...i}与B{0}相交的位置开始到结束dp[i][0]都等于1
        for (int i = 1; i < n; i++) {
            dp[i][0] = A.charAt(i) == B.charAt(0) ? 1 : dp[i - 1][0];
        }
//        第0行，B{0 ...i}与A{0}相交的位置开始到结束dp[0][i]都等于1
        for (int i = 1; i < m; i++) {
            dp[0][i] = A.charAt(0) == B.charAt(i) ? 1 : dp[0][i - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A.charAt(i) == B.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {

    }
}
