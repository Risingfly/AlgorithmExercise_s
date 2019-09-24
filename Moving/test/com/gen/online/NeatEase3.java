package com.gen.online;

import java.util.Scanner;

public class NeatEase3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int t = Integer.parseInt(read.nextLine());
            for (int i = 0; i < t; i++) {
                int n = Integer.parseInt(read.nextLine());
                String[] str1 = read.nextLine().split(" ");
                long[] nums = new long[n];
                for (int j = 0; j < n; j++) {
                    nums[j] = Long.parseLong(str1[j]);
                }
                System.out.println(solve(nums,n));
            }
        }
    }
    private static int solve(long[] nums,int n){
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (getSum(nums,j) <= nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
    private static long getSum(long[] nums,int i){
        long sum = 0;
        for (int j = 0; j <= i; j++) {
            sum += nums[j];
        }
        return sum;
    }
}
