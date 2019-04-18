package com.gen.sword.offer;

/***
 * 问题：二维数组中查找某个数
 * @author Genge
 */
public class TwoDimensionalArray {
    public boolean Find(int target, int [][] array){
        int right = array.length - 1;
        int low = 0;
        int high = array[0].length - 1;
        while (low <= high && right >= 0){
            if (array[low][right] < target){
                low++;
            }else if (array[low][right] > target){
                right--;
            }else {
                return true;
            }
        }
        return false;
    }
}
