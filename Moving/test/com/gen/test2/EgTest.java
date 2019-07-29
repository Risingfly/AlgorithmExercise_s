package com.gen.test2;

public class EgTest {
    public static int feiBo(int n){
        int[] mem = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            mem[i] = -1;
        }
        return feiBoMemo(n,mem);
    }
    public static int feiBoMemo(int n,int[] mem){
        if (mem[n] != -1){
            return mem[n];
        }
        if (n <= 2){
            mem[n] = 1;
        }else {
            mem[n] = feiBoMemo(n - 1,mem) + feiBoMemo(n - 2,mem);
        }
        return mem[n];
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        System.out.println(getSum(arr,arr.length - 1));
        System.out.println("feibo= "+feiBo(10));
    }
    public static int getSum(int[] arr,int n){
//        int sum = arr[n];
        if (n == 0){
            return arr[0];
        }
//        sum += arr
        return arr[n] +  getSum(arr,n - 1);
    }
}
