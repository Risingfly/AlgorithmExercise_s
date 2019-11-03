package com.gen.online;

public class CtripII0 {
    public static void main(String[] args) {
        System.out.println();
    }
    static boolean CheckBlackList(String userIP, String blackIP) {
        int index1 = userIP.lastIndexOf(".");
        String uip = userIP.substring(0,index1);
        int index2 = blackIP.lastIndexOf(".");
        String bip = blackIP.substring(0,index2);
        if (uip.equals(bip)){
            return true;
        }else {
            return false;
        }
    }
    static int DynamicPathPlanning(int[][] matrixGrid) {
        int m = matrixGrid.length;
        int n = matrixGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (matrixGrid[0][i] == 0){
                dp[0][i] = 1;
            }else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrixGrid[i][0] == 0){
                dp[i][0] = 1;
            }else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrixGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    if (matrixGrid[i][j - 1] == 0 && matrixGrid[i - 1][j] == 0){
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }else if (matrixGrid[i][j - 1] == 0){
                        dp[i][j] = dp[i][j - 1];
                    }else if (matrixGrid[i - 1][j] == 0){
                        dp[i][j] = dp[i - 1][j];
                    }else {
                        dp[i][j] = 0;
                    }
                }


            }
        }
        return dp[m - 1][n - 1];
    }
    public int uniquePathsWithObstacles(int[][] matrixGrid) {
//        行
        int m = matrixGrid.length;
//        列
        int n = matrixGrid[0].length;
        int[][] dp = new int[m][n];
//        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; i++) {
            if (matrixGrid[0][i] == 0){
                dp[0][i] = 1;
            }else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrixGrid[i][0] == 0){
                dp[i][0] = 1;
            }else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrixGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    if (matrixGrid[i][j - 1] == 0 && matrixGrid[i - 1][j] == 0){
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }else if (matrixGrid[i][j - 1] == 0){
                        dp[i][j] = dp[i][j - 1];
                    }else if (matrixGrid[i - 1][j] == 0){
                        dp[i][j] = dp[i - 1][j];
                    }else {
                        dp[i][j] = 0;
                    }
                }


            }
        }
        return dp[m - 1][n - 1];
    }
}

