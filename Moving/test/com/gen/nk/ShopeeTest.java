package com.gen.nk;

import java.util.Scanner;

public class ShopeeTest {
    public static int getNums(int x,int y,int[][] visited){
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y ; j++) {
                if (i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                if (visited[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0){
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                if (j == 0){
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[x][y];
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int x = read.nextInt();
        int y = read.nextInt();
        int n = read.nextInt();
        int[][] visited = new int[x + 1][y + 1];
        for (int i = 0; i < n; i++) {
            int a = read.nextInt();
            int b = read.nextInt();
            visited[a][b] = -1;
        }
        System.out.println(getNums(x,y,visited));
    }
}
