package com.gen.leetcode.top100;

/**
 * 问题：48
 * 思路：顺时针：先将矩阵上下行交换，再对镜像进行交换（m[i][j] ==> m[j][i]），即可。
 *      逆时针：先将矩阵左右列交换，再对镜像进行交换（m[i][j] ==> m[j][i]），即可。
 * @author Genge
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int hi = matrix.length - 1;
        int lo = 0;
        while (lo < hi){
//            交换矩阵整行或整列，可以直接交换整个数组
            int[] tmp = matrix[hi];
            matrix[hi] = matrix[lo];
            matrix[lo] = tmp;
            lo++;
            hi--;
        }
        for(int i = 0; i <= matrix.length - 1; i++){
//            交换镜像，j = i + 1避开 i == j情况
            for(int j = i + 1; j <= matrix[0].length - 1; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
