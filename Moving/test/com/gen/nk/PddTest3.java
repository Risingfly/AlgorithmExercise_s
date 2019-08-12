package com.gen.nk;

import java.util.Scanner;

public class PddTest3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNextLine()){
            String str1 = read.nextLine();
            int n = Integer.parseInt(str1);

            String[] str2 = read.nextLine().split(" ");
            int[] nums = new int[n];
            int m = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(str2[i]);
                m += nums[i];
            }

        }
    }
    private static boolean dfs(int[] a,int[] b,int n,int m,int step){
        if (m == 0){
            return true;
        }
        for (int i = 0; i < m; i++) {
            if (a[i] * 2 > m + 1){
                return false;
            }
            if (a[i] > 0 && b[step - 1] != i + 1){
                a[i]--;
                m--;
                b[step] = i + 1;
                if (dfs(a,b,n,m,step + 1)){
                    return true;
                }
                a[i]++;
                m++;
            }
        }
        return false;
    }
}
