package com.gen.online;

import java.util.Arrays;
import java.util.Scanner;

public class BeKe3 {
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
            Arrays.sort(nums);
            int[] res = slove(nums,n);
            System.out.println(res[0]+" "+res[1]);
        }
    }
    private static int[] slove(int[] nums,int n){
        int k = n - 1;
        int min = Integer.MAX_VALUE;
        int sum1 = 0;
        int index = 0;
        for (int i = k; i >= 0 ; i--) {
            int sum2 = 0;
            sum1 += nums[k];
            for (int j = 0; j < k; j++) {
                sum2 += nums[j];
            }
            index = min > Math.abs(sum1 - sum2) ? k :index;
            min = Math.min(min,Math.abs(sum1 - sum2) );
        }
        int[] res = new int[2];
        res[0] = min;
        res[1] = index;
        return res;
    }
}
