package com.gen.test2;

public class RobTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(rob(arr,0,-1));
    }
    public static int rob(int[] arr,int start,int max){
        int sum = 0;
        for (int i = start; i < arr.length; i++) {
            sum += arr[i];
            max = max > sum ? max : sum;
            rob(arr,i + 2,max);
        }
        return max;
    }
    public static int rob(int[] arr){
        if (arr == null){
            return -1;
        }
        int[] dp = new int[arr.length + 1];
        dp[0] = 0;
        dp[1] = arr[0];
        for (int i = 2; i <= arr.length ; i++) {
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + arr[i - 1]);
        }
        return dp[arr.length];
    }
}
