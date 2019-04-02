package com.gen.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();

            if(n < 2 || n > 1000000000 || m < 1 || n % m*2 != 0) {
                System.out.println("n, m 不符合要求，请重新输入...");
            }else {

                getSum(n,m);
                break;
            }
        }
    }
    public static int getSum(int n, int m){
        return (n/(2*m)) * m * m;
    }


}
