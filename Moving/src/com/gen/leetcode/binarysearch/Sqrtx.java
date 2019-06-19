package com.gen.leetcode.binarysearch;

/**
 * 问题：69
 * 总结：二分查找时，当结束条件为r < l时，最后的结束落在 r == l的位置；
 *                   当结束条件为r <= l时，最后的位置取决于查找的目标值，
 *                   若目标值target小于初始的中间值位置（r + l）/2,则可以返回r,最后落在小于中间值的前一位置；
 *                   若目标值target大于初始的中间位置（r + l）/2,则可以返回l,最后落在大于中间值的后一位置
 * @author Genge
 */
public class Sqrtx {
    public int mySqrt(int x) {
        int l = 1;
        int r = x;
//        使用小于等于的精妙之处在于，本题会出现截断小数位的情况
//        因此，最终值只可以小于等于根号x的整数部分，
//        而return r的话，正好r最后处于小于中间值的位置
        while(l <= r){
            int mid = (l + r) >> 1;
            if(mid == x/mid){
                return mid;
            }else if(mid < x/mid){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return r;
    }
}
