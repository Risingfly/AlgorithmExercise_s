package com.gen.leetcode.binarysearch;

/**
 * 问题：74
 * @author Genge
 */
public class Search2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
//         二维数组判空
        if((matrix == null || matrix.length == 0) || matrix.length == 1 && matrix[0].length == 0){
            return false;
        }
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int fr = 0;
        int fc = 0;
        int lr = row;
        int lc = col;
        while(fr <= lr && fc <= lc){
            int mid = matrix[lr][fc];
            if(mid == target){
                return true;
            }else if(mid < target){
                fc++;
            }else{
                lr--;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int start = 0, rows = matrix.length, cols = matrix[0].length;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            }
            if (matrix[mid / cols][mid % cols] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
