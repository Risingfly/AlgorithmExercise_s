package com.gen.test;

public class FindSnow {
    public static void main(String[] args) {
        char[][] m = {{'.','.','*','.','.','.','.','.','*','*'},
                {'.','*','*','.','.','*','*','*','*','*'},
                {'.','*','.','.','.','*','.','.','.','.'},
                {'.','.','*','*','*','*','.','*','*','*'},
                {'.','.','*','*','*','*','.','*','*','*'}};
        System.out.println(getSnow(m));

    }
    private static int getSnow(char[][] matrix){
        int r = matrix.length;
        int c = matrix[0].length;
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                max = Math.max(max,dfs(matrix,r,c,i,j));
            }
        }
        return max;
    }
    private static int dfs(char[][] m,int r,int c,int i,int j){
        if (i < 0 || i >= r || j < 0 || j >= c
                || m[i][j] != '*'){
            return 0;
        }
        m[i][j] = '.';
        return 1 + dfs(m,r,c,i + 1,j) + dfs(m,r,c,i - 1,j) + dfs(m,r,c,i,j + 1) +
                dfs(m,r,c,i,j - 1);
    }
}
