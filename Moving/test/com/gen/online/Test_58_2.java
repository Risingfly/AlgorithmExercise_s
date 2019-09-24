package com.gen.online;

import java.util.Arrays;
import java.util.Scanner;

public class Test_58_2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int n = read.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = read.nextInt();
            }
            System.out.println(candy(nums));
        }
    }
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                res[i] = res[i - 1] + 1;
            }
        }

        for(int i = n - 1; i > 0; i--){
            if(ratings[i - 1] > ratings[i]){
                res[i - 1] = Math.max(res[i] + 1, res[i - 1]);
            }
        }

        int sum = 0;
        for(int r: res) sum += r;

        return sum;
    }
}
