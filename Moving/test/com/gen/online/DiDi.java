package com.gen.online;

import java.util.Arrays;
import java.util.Scanner;

public class DiDi {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String str1 = read.nextLine();
            int n = Integer.parseInt(str1);
            String[] str2 = read.nextLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                if (str2[i].equals("*") || str2[i].equals("/")){
                    continue;
                }
                nums[i] = Integer.parseInt(str2[i]);
            }
            Arrays.sort(nums);

        }
    }
}
