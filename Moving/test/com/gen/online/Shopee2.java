package com.gen.online;

import java.util.Scanner;

public class Shopee2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int n = read.nextInt();
            int[] nums = {20,10,5,4,2,1};
            System.out.println(slove(nums,n));
        }
    }
    public static int slove(int[] nums, int target) {
        if (target == 0 || nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        for (int coin : nums) {
            for (int i = coin; i <= target; i++) {
                if (i == coin) {
                    dp[i] = 1;
                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;
                } else if (dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[target] == 0 ? -1 : dp[target];
    }
}
