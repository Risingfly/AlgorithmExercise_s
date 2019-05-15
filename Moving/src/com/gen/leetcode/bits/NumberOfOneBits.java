package com.gen.leetcode.bits;

/**
 * 问题：191
 * @author Genge
 */
public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
//            一个数与上1就是将其它位置为0，测试最后一位是否为1
            if ((n & 1) == 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
