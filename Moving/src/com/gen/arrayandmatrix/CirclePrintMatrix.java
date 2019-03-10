package com.gen.arrayandmatrix;

/***
 * 转圈打印矩阵
 * @author Genge
 */
public class CirclePrintMatrix {

    public static void main(String[] args) {
        int [][]m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printCircle(m);
    }
    private static void printCircle(int[][] matrix){
        int tr = 0;
        int tc = 0;
        int dr = matrix.length - 1;
        int dc = matrix[0].length - 1;
        while (tr <= dr && tc <= dc){
            printEdge(matrix,tr++,tc++,dr--,dc--);
        }
    }

    private static void printEdge(int[][]m, int tr, int tc, int dr, int dc){
        //矩阵只有一行时
        if (tr == dr){
            for (int i = tc; i < dc; i++) {
                System.out.println(m[tr][i]+" ");
            }
            //矩阵只有一列时
        }else if (tc == dc){
            for (int i = tr; i < dr; i++) {
                System.out.println(m[i][tc]+" ");
            }
        }else {
            int curC = tc;
            int curR = tr;
            while (curC != dc){
                System.out.println(m[dr][curC++]+" ");
            }
            while (curR != dr){
                System.out.println(m[curR++][tc]+" ");
            }
            while (curC != tc){
                System.out.println(m[tr][curC--]+" ");
            }
            while (curR != tr){
                System.out.println(m[curR--][dc]+"");
            }

        }
    }
}
