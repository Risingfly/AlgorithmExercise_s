package com.gen.leetcode.binarysearch;

/**
 * 问题：50
 * @author Genge
 */
public class Pow {
    public double myPow(double x, int n) {
//        递归出口
        if(n == 0){
            return 1;
        }
//        最小值时的绝对值 大于 整数最大值会溢出，所以单独处理
//        将x自乘然后将n减小一半
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n >> 1;
        }
//        负数调整为正数
        if(n < 0){
            n = -n;
            x = 1/x;
        }
//        无论偶数奇数，n都会要变成1，最后变成0出去
//        左边乘数的累乘最后为结果，myPow()最后一定是出口1
        return n % 2 == 0 ? myPow(x * x,n/2) : x * myPow(x * x, n/2);
    }
}
