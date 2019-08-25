package com.gen.online;

import java.util.Scanner;

public class BeKe1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] str1 = read.nextLine().split(" ");
            int n = Integer.parseInt(str1[0]);
            int k = Integer.parseInt(str1[1]);

            String t = read.nextLine();
            if (isSame(t)){
                String sub = t.substring(0,1);
                String res = t;
                for (int i = 1; i < k; i++) {
                    res = res + sub;
                }
                System.out.println(res);
            }else if (isBalance(t)){
                String sub = t.substring(t.length()/2,t.length());
                String res = t;
                for (int i = 1; i < k; i++) {
                    res = res + sub;
                }
                System.out.println(res);
            }else {
                String res = "";
                for (int i = 0; i < k; i++) {
                    res = res + t;
                }
                System.out.println(res);
            }

        }
    }
    private static boolean isSame(String str){
        int len = str.length();
        int i = 0,j = len - 1;
        while (i < len && j >= 0){
            if (str.charAt(i++) != str.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    private static boolean isBalance(String str){
        int n = str.length();
        if ((n & 1) == 1){
            int mid = n/2;
            int i = 0;
            int j = mid + 1;
            while (i < mid && j < n){
                if (str.charAt(i++) != str.charAt(j++)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
