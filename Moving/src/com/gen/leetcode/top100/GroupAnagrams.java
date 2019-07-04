package com.gen.leetcode.top100;

import java.util.*;

/**
 * 问题：49
 * 思路：将数组中的字符串进行排序，此时含有相同字符的串则有了共同的key,然后将其加入到list中即可
 * @author Genge
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0){
            return res;
        }
        Map<String,List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
//            第一次则新建一个list
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
//            无论是否第一次都将其加入该list中
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
