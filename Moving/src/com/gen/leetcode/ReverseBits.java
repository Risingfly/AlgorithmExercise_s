package com.gen.leetcode;

/**
 * 问题：190
 * @author Genge
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            res= ( res << 1 ) | ( n & 1 );
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = a & 1;
        int c = 0 << 1;
        System.out.println(c);
        System.out.println("a="+(a & 1));
    }
}
