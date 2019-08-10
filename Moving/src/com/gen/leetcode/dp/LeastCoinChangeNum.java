package com.gen.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class LeastCoinChangeNum {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0){
            return -1;
        }
        int res = 0;
        return coinChange(coins,amount,res,new ArrayList<>());
    }
    public int coinChange(int[] coins, int amount, int res, List<Integer> tmp){
        if (amount == 0){
            for (int num : tmp){
                res += num;
            }
            return res;
        }else {
            for (int i = 1; i <= amount && coins[i] <= amount; i++) {
                tmp.add(i);
                coinChange(coins,amount - coins[i - 1],res,tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
        return -1;
    }
}
