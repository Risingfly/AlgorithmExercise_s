package com.gen.nk;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String str1 = read.nextLine();
            int n = Integer.parseInt(str1);

            String[] str2 = read.nextLine().split(" ");
            double[] nums = new double[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Double.parseDouble(str2[i]);
            }
            double res = slove(nums,n);
            System.out.println(String.format("%.2f",res));

        }
    }
    private static double slove(double[] nums,int n){
        Arrays.sort(nums);
        double min = Double.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            double res = getAve(nums,i);
            if (res < min){
                min = res;
            }
        }
        return min;
    }
    private static double getAve(double[] nums,int i){
        double ave = (nums[i - 1] + nums[i] + nums[i + 1])/3;
        double res = (nums[i - 1] - ave) * (nums[i - 1] - ave)+
                (nums[i] - ave) * (nums[i] - ave) + (nums[i + 1] - ave) * (nums[i + 1] - ave);
        res = res / 3;
        return res;
    }
}
