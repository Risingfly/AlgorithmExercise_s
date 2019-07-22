package com.gen.leetcode.dfs;

/**
 * 问题:130
 * 思路:dfs函数用来进行搜索,每次在边界上出现O的地方进行深度优先搜索,将O置为*,
 * 主函数首先将边界上出现O的地方,用dfs将其置为*,
 * 最后扫描整个矩阵,出现O的地方都置为X即可
 * @author Genge
 */
public class SurroundedRegions {
    public void solve(char[][] board){
        if (board.length < 3 || board[0].length < 3) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O'){
                dfs(board,i,0);
            }
            if (board[i][n - 1] == 'O'){
                dfs(board,i,n - 1);
            }
        }
        for (int i = 1; i < n -1; i++) {
            if (board[0][i] == 'O'){
                dfs(board,0,i);
            }
            if (board[m - 1][i] == 'O'){
                dfs(board,m - 1,i);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * 深度优先搜索,上下左右进行搜索
     * @param m
     * @param r
     * @param c
     */
    public void dfs(char[][] m,int r,int c){
        if (r < 0 || r > m.length - 1 || c < 0 || c > m[0].length - 1 || m[r][c] != 'O'){
            return;
        }
        m[r][c] = '*';
        dfs(m,r + 1,c);
        dfs(m,r - 1,c);
        dfs(m,r,c + 1);
        dfs(m,r,c - 1);
    }
}
