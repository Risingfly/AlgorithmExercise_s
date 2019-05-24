package com.gen.leetcode.dp;

/**
 * 问题:91
 * @author Genge
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0){
            return -1;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i -1) != '0'){
                dp[i] = dp[i - 1];
            }
            int two = Integer.parseInt(s.substring(i - 2,i));
            if (two >= 10 && two <= 26){
                dp[i] += dp[i -2];
            }
        }
        return dp[len];
    }
}
