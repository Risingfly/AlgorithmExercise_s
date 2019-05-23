package com.gen.leetcode.dp;


/**
 * 问题:5
 * 某字符串的最大回文串
 * @author Genge
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1){
            return s;
        }
        int len = s.length();
        int max = -1;
        int l = 0;
        int r = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == s.charAt(i)){
                    char[] chars = s.substring(j,i + 1).toCharArray();
                    if (isPalindromicSubstring(chars)){
                        if (max < i - j + 1){
                            max = i - j +1;
                            l = j;
                            r = i + 1;
                        }
                    }
                }
            }
        }
        return s.substring(l,r);
    }
    public static boolean isPalindromicSubstring(char[] chars){
        int l = 0;
        int r = chars.length -1;
        while (l < r){
            if (chars[l] != chars[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        longestPalindrome("ac");
    }
}
