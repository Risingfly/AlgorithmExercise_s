package com.gen.leetcode;

/**
 * 问题:389
 * 方法:转成字符进行异或
 * @author Genge
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int tmp = 0;
        for (int i = 0; i < sarr.length; i++) {
            tmp ^= sarr[i];
        }
        for (int i = 0; i < tarr.length; i++) {
            tmp ^= tarr[i];
        }
        return (char)tmp;
    }
}
