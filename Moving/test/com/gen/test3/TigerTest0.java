package com.gen.test3;

import java.util.Scanner;

public class TigerTest0 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int n = read.nextInt();
            long[] x = new long[n];
            long[] y = new long[n];
            for (int i = 0; i < n; i++) {
                x[i] = read.nextLong();
                y[i] = read.nextLong();
            }
            long xmin = getValue(x,false);
            long xmax = getValue(x,true);
            long xlen = xmax - xmin;
            long ymin = getValue(y,false);
            long ymax = getValue(y,true);
            long ylen = ymax - ymin;
            long end = Math.max(xlen,ylen);
            System.out.println(end * end);
        }
    }
    private static long getValue(long[] arr,boolean flag){
        if (flag){
            long max = Long.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max){
                    max = arr[i];
                }
            }
            return max;
        }else {
            long min = Long.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < min){
                    min = arr[i];
                }
            }
            return min;
        }
    }
}
