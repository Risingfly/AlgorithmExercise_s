package com.gen.test;

import java.util.ArrayList;
import java.util.List;

public class TestWordBreak {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String str = "leetcode";
        list.add("leet");
        list.add("code");
        boolean flag = wordBreak(str,list);
        System.out.println(flag);
    }
    public static boolean wordBreak(String s, List<String> wordDict){
        if (s == null || s.length() == 0){
            return false;
        }
        int n = s.length();
        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String tmp = s.substring(j,i + 1);
                if (wordDict.contains(tmp) && (j == 0 || dp[j - 1])){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}
