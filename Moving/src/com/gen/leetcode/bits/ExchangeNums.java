package com.gen.leetcode.bits;

/**
 * 问题:不用额外变量交换两个数的值
 * @author Genge
 */
public class ExchangeNums {
    public void exchageNums(int a,int b){
//      异或运算具有交换律的作用
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
