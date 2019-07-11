package com.gen.nk;

public class SquirrelJump {
    public static int jump(int n){
        if (n == 0 || n == 1 || n == 2){
            return 0;
        }
        if (n == 3 || n == 4 || n == 5){
            return 1;
        }
        return jump(n - 3) + jump(n - 4) + jump(n - 5);
    }

    public static int getMin(int[] beans,int n){
        if (beans == null || n == 0){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = beans[0];
        dp[3] = beans[0] + beans[2];
        dp[4] = beans[0] + beans[3];
        dp[5] = beans[0] + beans[4];
        for (int i = 6; i <= n; i++) {
            dp[i] = Math.min(dp[i - 3],Math.min(dp[i - 4],dp[i - 5])) + beans[i - 1];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int[] beans = {4,3,0,1,0};
        System.out.println("res= "+getMin(beans,beans.length));
    }
}
