package com.gen.sword.offer;

import java.util.concurrent.ConcurrentHashMap;

/***
 * 问题：求两个整数之和不用加减乘除
 * 解法：1）两个数异或：相当于每一位相加，而不考虑进位；
        2）两个数相与，并左移一位：相当于求得进位；
       3）将上述两步的结果相加（直到进位为0，表示相加结束）
 * @author Genge
 */
public class SumOfInteger {
    public int Add(int num1,int num2) {
        while (num2 != 0){
//            二进制每位相加就相当于各位做异或操作(不包含进位)
            int temp = num1 ^ num2;
//            计算进位（先进行与运算再进行左移）
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        /**
         while( num2!=0 ){
         int sum = num1 ^ num2;
         int carray = (num1 & num2) << 1;
         num1 = sum;
         num2 = carray;
         }
         return num1;
         */
        return num1;
    }
}
