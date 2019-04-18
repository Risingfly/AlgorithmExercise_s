package com.gen.sword.offer;

public class DoublePower {
    public double Power(double base, int exponent) {
        double res = 1.0;
        int sym = 0;
        if (exponent == 0){
            return res;
        }else if (exponent < 0){
            sym = Math.abs(exponent);
        }else {
            sym = exponent;
        }

        while (sym != 0){
            if ((sym & 1) != 0){
                res *= base;
            }
            base *= base;
            sym >>= 1;
        }
        return exponent < 0 ? -res : res;
    }
}
