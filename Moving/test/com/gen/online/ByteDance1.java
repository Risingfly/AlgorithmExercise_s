package com.gen.online;

import java.util.Arrays;
import java.util.Scanner;

public class ByteDance1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int n = Integer.parseInt(read.nextLine());
            String[] str1 = read.nextLine().split(" ");
            long k = Long.parseLong(read.nextLine());

            long[] nums = new long[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Long.parseLong(str1[i]);
            }
            int res = slove(nums,n,k);
            System.out.println(res);
        }
    }
    private static int slove(long[] nums,int n,long k){
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            long aim = k - nums[i];
            int l = i + 1,r = n - 1;
            while (l < r){
                if (nums[l] + nums[r] < aim){
                    count += r - l;
                    l++;
                }else if (nums[l] + nums[r] >= aim){
                    r--;
                }
            }
        }
        return count;
    }

}
