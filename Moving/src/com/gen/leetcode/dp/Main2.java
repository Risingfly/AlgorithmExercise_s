package com.gen.leetcode.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String str1 = read.nextLine();
            int n = Integer.parseInt(str1);

            String[] str = read.nextLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(str[i]);
            }
            int res = n * (n - 1);
            res = res/2;
            System.out.println(res);
        }
    }
    private static int solve(int[] nums,int n){
        Arrays.sort(nums);
        int res = nums[n - 1] + 1;
        return res;
    }
}
