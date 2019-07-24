package com.gen.leetcode.dfs;



/**
 *问题:547
 * @author Genge
 */
public class FriendCircles {

    private static int num = 0;
    public static void main(String[] args) {
        int[][] arr ={{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        int tmp = findCircleNum(arr);
        System.out.println("res="+tmp);
    }
    public static int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0){
            return 0;
        }
        int m = M.length;
        int n = M[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1){
                    num = 0;
                    int tmp = dfs(M,i,j);
                    if (tmp > 1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private static int dfs(int[][] m,int r,int c){
        if (r < 0 || r > m.length - 1 || c < 0 || c > m[0].length - 1 || m[r][c] != 1){
            return 0;
        }
        m[r][c] = 0;
        num++;
        dfs(m,r + 1,c);
        dfs(m,r - 1,c);
        dfs(m,r,c + 1);
        dfs(m,r,c - 1);
        return num;
    }
}
