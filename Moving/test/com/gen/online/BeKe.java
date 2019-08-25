package com.gen.online;

import java.util.Arrays;
import java.util.Scanner;

public class BeKe {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] str1 = read.nextLine().split(" ");
            int n = Integer.parseInt(str1[0]);
            long s = Long.parseLong(str1[1]);

            long[] nums = new long[n];
            String[] str2 = read.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Long.parseLong(str2[i]);
            }
            Arrays.sort(nums);
            int count = 0;
            long sum = nums[0];
            for (int i = 1; i < n; i++) {
                if (sum <= s){
                    count++;
                }
                sum += nums[i];
            }
            System.out.println(count);
        }
    }
}
