package com.gen.test3;

import java.util.Scanner;
import java.util.Stack;

public class TigerTest2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int q = read.nextInt();
            for (int i = 0; i < q; i++) {
                int k = read.nextInt();
                int l = read.nextInt();
                long r = read.nextLong();
                int count = 0;
                for (int j = l; j <= r; j++) {
                    String str = String.valueOf(convert(j,k));
                    String str1 = String.valueOf(l);
                    count += getCount(str,str1);
                }
                System.out.println(count);
            }
        }

    }
    private static int convert(int n,int k){
        Stack<Integer> stack = new Stack<>();
        int tmp = n;
        while (tmp > 0){
            stack.push(tmp % k);
            tmp /= k;
        }
        int m = 0;
        while (!stack.isEmpty()){
            m = m * 10 + stack.pop();
        }
        return m;
    }
    public static int getCount(String str, String tag) {
        int index = 0;
        int count = 0;
        while ((index = str.indexOf(tag)) != -1) {
            str = str.substring(index + tag.length());
            count++;
        }
        return count;
    }
}
