package com.gen.nk;

import java.util.Scanner;

public class Test {
    /**
     * 计算某一个方向满足条件的次数，为-1时无法判断
     * @param distance 该方向下最少传递次数
     * @param last
     * @return
     */
    private static int calcDirectionCount(int last, int distance){
        int remain = last - distance;
        // 距离太远，或多余一次传递，均无法成功
        if(remain < 0 || (remain % 2 == 1)){
            return 0;
        }
        return remain == 0 ? 1 : -1;
    }

    /**
     * 符合条件下，有多少种传递情况
     * @param n 总人数
     * @param index 当前传递到的人（1-n）
     * @param last 还剩下的传递次数
     * @return 符合条件下，有多少种传递情况
     */
    private static int calcCount(int n, int index, int last){
        // 已经传到最后不需要再传了
        if(last == 0){
            return index == 1 ? 1 : 0;
        }
        // 利用对称性
        if(index == 1){
            return 2 * calcCount(n, index + 1, last -1);
        }
        // 看是否能直接判断出结果
        int leftCount = calcDirectionCount(last, index - 1);
        int rightCount = calcDirectionCount(last, n - index + 1);
        if(leftCount > -1 && rightCount > -1){
            return leftCount + rightCount;
        }
        // 继续向左边、向右传递
        leftCount = calcCount(n, index > 1 ? index - 1 : n, last - 1);
        rightCount = calcCount(n, index < n ? index + 1 : 1, last - 1);
        return leftCount + rightCount;
    }


    /**
     * 计算 从第一个人传递m次后回到第一个的情况数
     * @param n 总人数
     * @param m 传递次数
     * @return 从第一个人传递m次后回到第一个的情况数
     * @throws Exception
     */
    private static int calcCount(int n, int m) throws Exception {
        if(n < 1 || m < 0){
            throw new Exception("数据错误！");
        }
        if(m > 0 && n <= 1){
            throw new Exception("单节点无法传递！");
        }
        int count = -1;
        if(n == 2){
            // 2的情况比较特殊，向左向右都一样
            count = m % 2 == 1 ? 0 : 1;
        }else{
            count = calcCount(n, 1, m);
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            int count = calcCount(n, m);
            System.out.println(count);
        }
    }

//    public static void main(String[] args){
//        Scanner read = new Scanner(System.in);
//        int n = read.nextInt();
//        int knum = read.nextInt();
//        System.out.println(getRes(n,knum));
//    }
    public static int getRes(int n,int knum){
        int count = 1;
//        int k = 0;
//        while(k < n){
//            k++;
//            if(k % (knum - 1) == 0){
//                count++;
//
//            }
//        }
        if(n % knum == 0){
            count++;
        }
        return count % 1000000007;
    }
}
