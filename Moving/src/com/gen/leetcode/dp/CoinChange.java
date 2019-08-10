package com.gen.leetcode.dp;

public class CoinChange {
    public int coinChange(int[] coins, int amount){
        if (amount == 0){
            return 0;
        }
        int n = amount + 1;
        for (int coin : coins){
            int cur = 0;
            if (coin <= amount){
                int next = coinChange(coins,amount - coin);
                if (next >= 0){
                    cur = next + 1;
                }
                if (cur > 0){
                    n = Math.min(n,cur);
                }
            }
        }
        return (n == amount + 1) ? -1 : n;
    }
    public int coinChange2(int[] coins, int amount){
        if (coins == null || coins.length == 0 || amount <= 0){
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (j == amount){
                    dp[j] = 1;
                }else if (dp[j] == 0 && dp[j - coins[i]] != 0){
                    dp[j] = dp[j - coins[i]] + 1;
                }else if (dp[j - coins[i]] != 0){
                    dp[j] = Math.min(dp[j],dp[j - coins[i]]);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
