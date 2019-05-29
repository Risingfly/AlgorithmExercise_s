package com.gen.leetcode.dp;

import java.util.List;

/**
 * 问题:139
 * @author Genge
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
//        包含空字符串
        boolean[] dp = new boolean[s.length() + 1];
//        空串
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
//            相当于从0开始遍历找到dp[j] = true,同时j到i之间正好存在字符串于list中
            for (int j = 0; j < i; j++) {
//                dp[i]等于true的前提是,dp[j]为true且之后j到i之间的字符正好存在于list中
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
