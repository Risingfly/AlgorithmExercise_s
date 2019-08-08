package com.gen.nk;

import com.gen.test3.InteIm;

import java.util.Arrays;
import java.util.Scanner;

public class PddTest {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] aa = read.nextLine().split(" ");
            String[] bb = read.nextLine().split(" ");
            int[] a = new int[aa.length];
            int[] b = new int[bb.length];
            for (int i = 0; i < aa.length; i++) {
                a[i] = Integer.parseInt(aa[i]);
            }
            for (int i = 0; i < bb.length; i++) {
                b[i] = Integer.parseInt(bb[i]);
            }
            int index = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] > a[i + 1]){
                    index = i;
                    break;
                }
            }
            int l1 = index == 0 ? Integer.MIN_VALUE : a[index - 1];
            int r1 = a[index + 1];
            int l2 = a[index];
            int r2 = index == a.length - 2 ? Integer.MAX_VALUE : a[index + 2];
            Arrays.sort(b);
            int i = b.length - 1;
            for (; i >= 0; i--) {
                if (b[i] > l1 && b[i] < r1){
                    a[index] = b[i];
                    break;
                }else if (b[i] > l2 && b[i] < r2){
                    a[index + 1] = b[i];
                    break;
                }
            }
            if (i == -1){
                System.out.println("NO");
            }else {
                for (int j = 0; j < a.length; j++) {
                    if (j != a.length - 1){
                        System.out.print(a[j]+ " ");
                    }else {
                        System.out.print(a[j]);
                    }
//                    if (j < a.length - 1){
//                        System.out.print(a[j] + " ");
//                    }
//                    System.out.print(a[j]);
                }
            }
        }
    }
}
