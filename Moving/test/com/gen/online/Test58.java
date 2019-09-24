package com.gen.online;

import java.util.Scanner;

public class Test58 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int n = read.nextInt();
            int m = read.nextInt();
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = read.nextInt();
                }
            }
            System.out.println(getMin(map,n,m));
        }
    }
    public static int getMin(int[][] map, int n, int m) {
        if(n <= 0 || m <= 0){
            return -1;
        }
        int[][] dp = new int[n][m];
        dp[0][0] = map[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i - 1][j] < dp[i][j - 1]){
                    dp[i][j] = map[i][j] + dp[i - 1][j];
                }else {
                    dp[i][j] = map[i][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
