package com.gen.nk;

import java.util.HashMap;
import java.util.Scanner;

public class ShopeeTest1 {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append('c');
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int x = read.nextInt();
            int y = read.nextInt();
            int n = read.nextInt();
            boolean[][] boss = new boolean[x + 1][y + 1];
            for (int i = 1; i <= n; i++) {
                int a = read.nextInt();
                int b = read.nextInt();
                boss[a][b] = true;
            }
            System.out.println(solve(x,y,n,boss));
        }
    }
    private static long solve(int x,int y,int n,boolean[][] boss){
        long[][] dp = new long[x + 1][y + 1];
        for (int i = 0; i <= x; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= y; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y ; j++) {
                if (boss[i][j]){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[x][y];
    }
}
