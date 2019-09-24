package com.gen.online;

import java.util.Scanner;

public class BiLi2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int sum = Integer.parseInt(read.nextLine());
            System.out.println(findConSequence(sum));
        }
    }

    public static int findConSequence(int sum) {
        int count = 1;
        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
            if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                count++;
            }
        }
        return count;
    }
//    public  static long findContinuousSequence(long sum) {
//        long l = 1;
//        long r = 2;
//        long count = 0;
//        while (l <= r){
//            //右移1位表示减半
//            long cur = (l + r) * (r - l + 1)/2;
//            if (cur == sum){
//                count++;
//                l++;
//            }else if (cur < sum){
//                r++;
//            }else {
//                l++;
//            }
//        }
//        return count;
//    }
}
