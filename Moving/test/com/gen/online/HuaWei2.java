package com.gen.online;

import java.util.Scanner;

public class HuaWei2 {
    private static int count = 0;
    public static void main(String[] args) {
        int[][] m = {{1,2,3,4,5},{11,12,13,14,15},{21,22,23,24,25},
                {31,32,33,34,35},{41,42,43,44,45}};
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] str1 = read.nextLine().split(" ");
            int[] target = new int[str1.length];
            for (int i = 0; i < target.length; i++) {
                target[i] = Integer.parseInt(str1[i]);
            }
            int dr = 0,dc = 0;
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    if (m[i][j] == target[0]){
                        dr = i;
                        dc = j;
                        break;
                    }
                }
            }
            int res = dfs(m,dr,dc,target);
            if (res == 5){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }
    private static int dfs(int[][] m,int r,int c,int[] target){
        if (r < 0 || r > m.length - 1 || c < 0 || c > m[0].length - 1){
            return 0;
        }
        if (m[r][c] == target[1] || m[r][c] == target[2] ||m[r][c] == target[3] ||
                m[r][c] == target[4] ||m[r][c] == target[5]){
            count++;
        }
        dfs(m,r + 1,c,target);
        dfs(m,r - 1,c,target);
        dfs(m,r,c + 1,target);
        dfs(m,r,c - 1,target);
        return count;
    }

}
