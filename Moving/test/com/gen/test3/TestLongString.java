package com.gen.test3;

public class TestLongString {
    public static void main(String[] args) {
       int res = getLongestCommonStr("1a2c3d4b56","b1d23ca45b6a");
//        int[] num1 = {1,2,4,6,7,8};
//        int[] num2 = {1,4,5,8};
//       int res = lengthOfLCS(num1,num2);
        System.out.println("res= "+ res);
    }

    public static int lengthOfLCS(int[] nums1, int[] nums2) {
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
    public static int getLongestCommonStr(String str1,String str2){
        if (str1 == null || str2 == null){
            return 0;
        }
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

//        if (str1.charAt(0) == str2.charAt(0)){
//            dp[0][0] = 1;
//        }
//        for (int i = 1; i < n; i++) {
//            if (str1.charAt(i) == str2.charAt(0)){
//                dp[i][0] = 1;
//            }else {
//                dp[i][0] = dp[i - 1][0];
//            }
//        }
//        for (int i = 1; i < m; i++) {
//            if (str2.charAt(i) == str1.charAt(0)){
//                dp[0][i] = 1;
//            }else {
//                dp[0][i] = dp[0][i - 1];
//            }
//        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];

    }
}
