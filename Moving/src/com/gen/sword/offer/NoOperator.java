package com.gen.sword.offer;

/**
 * 问题：求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 解决：使用&& 短路原理作为递归出口，后面用递归计算和
 * @author Genge
 */
public class NoOperator {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
