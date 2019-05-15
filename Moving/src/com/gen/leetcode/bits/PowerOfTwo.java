package com.gen.leetcode.bits;

/**
 * 问题：231
 * 方法：2的n次方意味着，该数的二进制中只有一个1，如1，10（2），100（4），1000（8）等
 *
 * @author Genge
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n < 1){
            return false;
        }
//        若n为2的次幂,则n - 1除最高位全为1,所以n & (n - 1)等于0
        return (n & (n - 1)) == 0;
    }
}
