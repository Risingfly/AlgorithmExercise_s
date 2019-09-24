package com.gen.online;

import java.util.Scanner;

public class BiLi1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String str1 = read.nextLine();
            String str2 = read.nextLine();
            System.out.println(leastDistance(str1,str2));
        }
    }
    public static int leastDistance(String str1, String str2) {
        int[][] dp = new int[str2.length()+1][str1.length()+1];
        for(int i = 0; i <= str2.length(); i++) {
            for(int j = 0; j <= str1.length(); j++) {
                if(i == 0 && j == 0) dp[i][j] = 0;
                else if(i == 0 && j != 0) {
                    dp[i][j] = j;
                } else if(i != 0 && j == 0) {
                    dp[i][j] = i;
                } else if(str2.charAt(i-1) != str1.charAt(j-1)) {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                }else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[str2.length()][str1.length()];
    }
}
