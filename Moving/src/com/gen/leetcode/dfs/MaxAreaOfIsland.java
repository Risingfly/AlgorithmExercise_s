package com.gen.leetcode.dfs;

/**
 * 问题：leetcode 695
 * @author Genge
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        MaxAreaOfIsland island = new MaxAreaOfIsland();
        System.out.println(island.maxAreaOfIsland(grid));
    }
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1){
                    max = Math.max(max,dfsMarking(grid,i,j,0));
                }
            }
        }
        return max;
    }
    private int dfsMarking(int[][] grid,int i,int j,int count){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || grid[i][j] == 0){
            return count;
        }
        grid[i][j] = 0;
//        递归有个掉栈的过程
////        count++;
//        dfsMarking(grid,i + 1,j,count);
//        dfsMarking(grid,i - 1,j,count);
//        dfsMarking(grid,i,j + 1,count);
//        dfsMarking(grid,i,j - 1,count);
//        此处的代码会回到最上层的递归代码之前，因此不好拿参数统计变量
//        统计最好用下面的代码最合适
        return 1 + dfsMarking(grid,i + 1,j,count) + dfsMarking(grid,i - 1,j,count) + dfsMarking(grid,i,j + 1,count)+
                dfsMarking(grid,i,j - 1,count);
//        return count;
    }
}
