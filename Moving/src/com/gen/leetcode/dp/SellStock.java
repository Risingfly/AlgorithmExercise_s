package com.gen.leetcode.dp;

/**
 * 问题:121
 * @author Genge
 */
public class SellStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int curMax = 0;
        int soFar = 0;
        for (int i = 1; i < n; i++) {
            curMax = Math.max(0,curMax += prices[i] - prices[i - 1]);
            soFar = Math.max(curMax,soFar);
        }
        return soFar;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        maxProfit(arr);
    }
}
