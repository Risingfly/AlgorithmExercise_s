package com.gen.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题:438
 * @author Genge
 */
public class AnagramInString {

    public List<Integer> findAnagrams1(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }
        int[] hash = new int[256];
        for (Character c: p.toCharArray()){
            hash[c]++;
        }
        int left = 0,right = 0,count = p.length();
        while (right < s.length()){
//            大于等1表示p中字符在s中出现,长度减一,表示离p更近一步
            if (hash[s.charAt(right)] >= 1){
                count--;
            }
//            出现一次后,统计减一
            hash[s.charAt(right)]--;
//            指针右移
            right++;
//            为0 表示找到p了,将初始下标加入结果
            if (count == 0){
                res.add(left);
            }
//            窗口值等于p的长度时
            if (right - left == p.length()){
                if (hash[s.charAt(left)] >= 0){
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return res;
    }
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()){
            return res;
        }
        int[] chars = new int[26];
//        统计p中字符词频
        for (Character c : p.toCharArray()){
            chars[c - 'a']++;
        }
        int start = 0,end = 0,len = p.length(),diff = len;
        char tmp;
        for (end = 0; end < len; end++){
            tmp = s.charAt(end);
            chars[tmp - 'a']--;
            if (chars[tmp - 'a'] >= 0){
                diff--;
            }
        }
        if (diff == 0){
            res.add(0);
        }
        while (end < s.length()){
            tmp = s.charAt(start);
            if (chars[tmp - 'a'] >= 0){
                diff++;
            }
            chars[tmp - 'a']++;
            start++;
            tmp = s.charAt(end);
            chars[tmp - 'a']--;
            if (chars[tmp - 'a'] > 0){
                diff--;
            }
            if (diff == 0){
                res.add(start);
            }
            end++;
        }
        return res;
    }
}
