package com.gen.online;

import java.util.Arrays;
import java.util.Scanner;

public class Mi {
    public static void main(String[] args) {
        int[] arr = {45,30,1};
        int res = solution(arr,100);
        System.out.println(res);
    }
    static int solution(int[] prices, int budget) {
        if (prices == null || prices.length == 0 || budget <= 0){
            return -1;
        }
        Arrays.sort(prices);
        int len = prices.length - 1;
        int min = prices[0];
        if (budget < min){
            return -1;
        }
        int count = 0;
        int i = len;

        while (budget > 0 && i >= 0){
            while (budget < prices[i] && i >= 0){
                i--;
            }
            int tmp = budget / prices[i];
            if (tmp == 0){
                break;
            }
            count += tmp;
            budget = budget - tmp * prices[i];
            i--;
        }
        return count;
    }
}
