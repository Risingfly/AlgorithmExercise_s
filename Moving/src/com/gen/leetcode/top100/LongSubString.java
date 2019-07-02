package com.gen.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题：3
 * @author Genge
 */
public class LongSubString {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0,j = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
//                 j记录重复字符的右移一位的位置
                j = Math.max(j,map.get(s.charAt(i)) + 1);
            }
//             即使有重复也直接覆盖
            map.put(s.charAt(i),i);
            max = Math.max(max,i - j + 1);
        }
        return max;
    }
}
