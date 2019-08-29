package com.gen.online;

import java.util.Scanner;

public class HuaWei3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String str1 = read.nextLine();
            int n = Integer.parseInt(str1);

            String[] str2 = read.nextLine().split(" ");
            long[] A = new long[n];
            for (int i = 0; i < n; i++) {
                A[i] = Long.parseLong(str2[i]);
            }
            String[] str3 = read.nextLine().split(" ");
            long[] B = new long[n];
            for (int i = 0; i < n; i++) {
                B[i] = Long.parseLong(str3[i]);
            }
            int res = n - lengthOfLCS(A,B);
            System.out.println(res);
        }
    }
    public static int lengthOfLCS(long[] nums1, long[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
