package com.gen.leetcode.top100;

/**
 * 问题：338
 * 思路：f[i] = f[i / 2] + i % 2
 * i & 1 相当与 i % 2
 * @author Genge
 */
public class CountingBits {
    public int[] countBits(int num){
        int[] res = new int[num + 1];
        for(int i = 1; i <= num; i++){
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
