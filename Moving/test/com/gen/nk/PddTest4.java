package com.gen.nk;

import java.util.Arrays;
import java.util.Scanner;

public class PddTest4 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNextLine()){
            String str1 = read.nextLine();
            int n = Integer.parseInt(str1);

            String[] str2 = read.nextLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(str2[i]);
            }
            System.out.println(solve(nums,n));
        }
    }
    private static int solve(int[] nums,int n){
        Arrays.sort(nums);
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0,j = n - 1; i < n/2; i++,j--) {
            max = Math.max(max,nums[i] + nums[j]);
            min = Math.min(min,nums[i] + nums[j]);
        }
        return max - min;
    }
}
