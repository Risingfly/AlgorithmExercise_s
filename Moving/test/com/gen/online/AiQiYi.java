package com.gen.online;

import java.util.Scanner;

public class AiQiYi {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int n = Integer.parseInt(read.nextLine());
            String[] str2 = read.nextLine().split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str2.length; i++) {
                if (str2[i].equals("0")){
                    sb.append('D');
                }else if (str2[i].equals("1")){
                    sb.append('I');
                }
            }
            String str = sb.toString();
            System.out.println(numPermsDISequence(str));
        }
    }
    public static int numPermsDISequence(String S) {
        int n = S.length(), mod = (int)1e9 + 7;
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 0; j <= n; j++) dp[0][j] = 1;
        for (int i = 0; i < n; i++)
            if (S.charAt(i) == 'I')
                for (int j = 0, cur = 0; j < n - i; j++)
                    dp[i + 1][j] = cur = (cur + dp[i][j]) % mod;
            else
                for (int j = n - i - 1, cur = 0; j >= 0; j--)
                    dp[i + 1][j] = cur = (cur + dp[i][j + 1]) % mod;
        return dp[n][0];
    }
}
