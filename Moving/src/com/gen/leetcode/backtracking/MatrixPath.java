package com.gen.leetcode.backtracking;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 问题：剑指offer 65
 * @author Genge
 */
public class MatrixPath {

    public static void main(String[] args) {
        MatrixPath matrixPath = new MatrixPath();
        String str = "abcesfcsadee";
        String str1 = "bcced";
        char[] matrix = str.toCharArray();
        char[] sub = str1.toCharArray();
        matrixPath.hasPath1(matrix,3,4,sub);
//        Scanner read = new Scanner(System.in);
//        while (read.hasNext()){
//
//        }
    }
    public boolean hasPath1(char[] matrix, int rows, int cols, char[] str) {
        int flag[] = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        if(k == str.length - 1) return true;
        flag[index] = 1;
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            System.out.println(matrix[k]+"k = "+k);
            return true;
        }
        flag[index] = 0;
        System.out.println("print 777");
        return false;
    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0){
            return false;
        }
        int[] visited = new int[matrix.length - 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(matrix,rows,cols,i,j,str,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtracking(char[] matrix, int rows, int cols,int i,int j, char[] str,int k,int[] visited){
//      在一维数组中的位置，用二维坐标表示
        int index = cols * i + j;
//        递归出口
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || visited[index] == 1){
            return false;
        }
        if (k == str.length - 1){
            return true;
        }
//        标记当前节点
        visited[index] = 1;
//        从当前节点上下左右的递归查找，若找到则返回true
//        if (backtracking(matrix,rows,cols,i + 1,j,str,k + 1,visited) ||
//                backtracking(matrix,rows,cols,i - 1,j,str,k + 1,visited) ||
//                backtracking(matrix,rows,cols,i,j + 1,str,k + 1,visited) ||
//                backtracking(matrix,rows,cols,i,j - 1,str,k + 1,visited)){
//            return true;
////        }
//                backtracking(matrix,rows,cols,i + 1,j,str,k + 1,visited);
//                backtracking(matrix,rows,cols,i - 1,j,str,k + 1,visited);
//                backtracking(matrix,rows,cols,i,j + 1,str,k + 1,visited);
//                backtracking(matrix,rows,cols,i,j - 1,str,k + 1,visited);
//        若从当前节点搜索不到，则回退，将其重新置为0
        visited[index] = 0;
        return false;
    }
}
