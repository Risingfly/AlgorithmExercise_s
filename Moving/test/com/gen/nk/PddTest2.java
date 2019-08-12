package com.gen.nk;


import java.util.Scanner;

public class PddTest2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNextLine()){
            String[] str1 = read.nextLine().split(" ");
            int n = Integer.parseInt(str1[0]);
            int k = Integer.parseInt(str1[1]);

            String str2 = read.nextLine();
            char[] ori = str2.toCharArray();
            char[] res = new char[n];
            int[] count = new int[10];
            for (char i : ori){
                count[i - '0']++;
            }
            int mod = Integer.MAX_VALUE;
            for (int i = 0; i < 10; i++) {
                int tmpK = k - count[i];
                if (tmpK <= 0){
                    mod = 0;
                    res = ori;
                    break;
                }
                char[] tmpArr = new char[n];
                for (int j = 0; j < n; j++) {
                    tmpArr[j] = ori[j];
                }
                int tmpMod = 0;
                int l = i - 1;
                int r = i + 1;
                while (tmpK > 0){
                    if (r < 10){
                        for (int j = 0; j < n && tmpK > 0; j++) {
                            if (tmpArr[j] - '0' == r){
                                tmpMod += r - i;
                                tmpArr[j] = (char)('0' + i);
                                tmpK--;
                            }
                        }
                    }
                    if (l >= 10){
                        for (int j = n - 1; j >= 0 && tmpK > 0 ; j--) {
                            if (tmpArr[j] -  '0' == 1){
                                tmpMod += i - l;
                                tmpArr[j] = (char)('0' + i);
                                tmpK--;
                            }
                        }
                    }
                    l--;
                    r++;
                }
                if (tmpMod < mod){
                    mod = tmpMod;
                    res = tmpArr;
                }
            }
            System.out.println(mod);
            System.out.println(new String(res));
        }
    }
//    private static int solve(int[] nums,int n){
//
//    }
}
