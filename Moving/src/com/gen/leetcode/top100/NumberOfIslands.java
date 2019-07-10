package com.gen.leetcode.top100;

/**
 * 问题：200
 * @author Genge
 */
public class NumberOfIslands {
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0){
            return 0;
        }
        m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
//                每找到一个‘1’，就在该位置的上下左右深度优先
//                进行搜索，同时将对应的‘1’置‘0’，计数加一
                if (grid[i][j] == '1'){
                    DFSMarking(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void DFSMarking(char[][] grid,int i,int j){
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1'){
            return;
        }
//        访问过后就将其置为‘0’，防止下次再访问
        grid[i][j] = '0';
//        在陆地位置的上下左右进行搜索
        DFSMarking(grid,i + 1,j);
        DFSMarking(grid,i - 1,j);
        DFSMarking(grid,i,j + 1);
        DFSMarking(grid,i,j - 1);

    }
}
