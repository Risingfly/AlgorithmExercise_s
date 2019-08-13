package com.gen.test3;

public class Robot {
    static int count = 0;

    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.movingCount(15,20,20);
        System.out.println("count: "+count);
    }
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0){
            return 0;
        }
        boolean[][] flag = new boolean[rows + 1][cols + 1];
        help(threshold,0,0,rows,cols,flag);
        return count;
    }
    private void help(int threshold,int r,int c,int rows,int cols,boolean[][] flag){
        int tmp = getSum(r) + getSum(c);
        if (r < 0 || r >= rows || c < 0 || c >= cols || tmp > threshold || flag[r][c]){
            return;
        }
        flag[r][c] = true;
        count++;
        help(threshold,r + 1,c,rows,cols,flag);
        help(threshold,r - 1,c,rows,cols,flag);
        help(threshold,r,c - 1,rows,cols,flag);
        help(threshold,r,c + 1,rows,cols,flag);
    }
    private int getSum(int n){
        int tmp = n;
        int sum = 0;
        while (tmp != 0){
            sum += tmp % 10;
            tmp = tmp / 10;
        }
        return sum;
    }
}
