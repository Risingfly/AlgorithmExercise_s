package com.gen.online;

import java.util.*;

public class Jd {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] str1 = read.nextLine().split(" ");
            int n = Integer.parseInt(str1[0]);
            int m = Integer.parseInt(str1[1]);

//            int[] boy = new int[n];
//            int[] girl = new int[n];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                String[] str2 = read.nextLine().split(" ");
                int a = Integer.parseInt(str2[0]);
                int b = Integer.parseInt(str2[1]);
                int tmp = a < b ? a : b;
                set.add(tmp);
            }
//            int[] res = slove(boy,girl,n);
            System.out.println(set.size());
            List<Integer> list = new ArrayList<>();
            for (int num : set){
                list.add(num);
            }
            Collections.sort(list);
            for (int num : list){
                System.out.println(num + " ");
            }
        }
    }
    private static int[] slove(int[] boy,int[] girl,int n){
        int[] cb = new int[n + 1];
        int[] cg = new int[2 * n + 1];
        for (int i = 0; i < boy.length; i++) {
            cb[boy[i]]++;
        }
        int bmax = -1;
        int bindex = -1;
        for (int i = 0; i < cb.length; i++) {
            if (cb[i] > bmax){
                bmax = cb[i];
                bindex = i;
            }
        }

        for (int i = 0; i < girl.length; i++) {
            cg[girl[i]]++;
        }
        int gmax = -1;
        int gindex = -1;
        for (int i = 0; i < cg.length; i++) {
            if (cg[i] > gmax){
                gmax = cg[i];
                gindex = i;
            }
        }
        int[] res = new int[3];
        res[0] = 2;
        res[1] = bindex < gindex ? bindex : gindex;
        res[2] = res[1] == bindex ? gindex : bindex;
        return res;
    }
}
