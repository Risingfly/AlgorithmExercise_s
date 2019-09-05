package com.gen.online;

import java.util.Scanner;

public class RedBook {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int n = read.nextInt();
            int m = read.nextInt();
            int k = read.nextInt();
            boolean[][] block = new boolean[n][m];

            for (int i = 1; i <= k; i++) {
                int a = read.nextInt();
                int b = read.nextInt();
                block[a][b] = true;
            }
            System.out.println(solve(n,m,block));
        }
    }
    private static long solve(int n,int m,boolean[][] block){
        long[][] dp = new long[n][m];
        if (block[0][0]){
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (block[i][0]){
                dp[i][0] = 0;
            }else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (block[0][i]){
                dp[0][i] = 0;
            }else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int x = i + 1,y = j + 1;
                if (block[i][j] || (x < n && y < m && block[i][y] && block[x][j])){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                    block[i][j] = true;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
