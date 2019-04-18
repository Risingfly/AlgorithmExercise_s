package com.gen.sword.offer;

public class Fibonaccis {
    public int Fibonacci(int n) {
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else if (n == 2){
            return 1;
        }else {
            return Fibonacci(n - 2) + Fibonacci(n - 1);
        }
    }
    public int Fibonacci2(int n){
        if (n == 0){
            return 0;
        }
        if (n > 0 && n < 3){
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 0; i < n ; i++) {
            c = a + b;
            a = c;
            b = a;
        }
        return c;
    }
}
