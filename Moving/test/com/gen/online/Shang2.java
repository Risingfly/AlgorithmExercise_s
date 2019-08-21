package com.gen.online;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 996
 */
public class Shang2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String str1 = read.nextLine();
            int n = Integer.parseInt(str1);
            String[] str2 = read.nextLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(str2[i]);
            }
            System.out.println(numSquarefulPerms(nums));
        }
    }
   static int res = 0;
    public static int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        dfs(A, 0, -1);
        return res;
    }

    private static void dfs(int[] A, int cnt, int prev) {
        if (cnt == A.length) {
            res++;
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] == -1) continue;

            if (i > 0 && A[i] == A[i - 1]) continue;

            int root = (int)Math.sqrt(A[i] + prev);
            if (prev != -1 && root * root != A[i] + prev) continue;

            int tmp = A[i];
            A[i] = -1;
            dfs(A, cnt + 1, tmp);
            A[i] = tmp;
        }
    }
}
