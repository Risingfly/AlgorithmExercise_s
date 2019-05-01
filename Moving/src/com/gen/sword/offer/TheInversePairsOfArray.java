package com.gen.sword.offer;

/***
 *在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * @author Genge
 */
public class TheInversePairsOfArray {
    public int InversePairs(int [] array) {
        if (array == null || array.length < 2){
            return 0;
        }
        int l = 0;
        int r = 1;
        int count = 0;
        while (r < array.length){
            if (array[l] > array[r]){
                count++;
            }
            l++;
            r++;
        }
        int res = count % 1000000007;
        return res;
    }
}
