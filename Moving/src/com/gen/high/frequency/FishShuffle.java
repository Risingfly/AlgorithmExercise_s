package com.gen.high.frequency;

import java.util.Arrays;
import java.util.Random;

/**
 * 洗牌算法：每次从数组中随机选择一个数和最后一个数交换位置，并且不再考虑最后一个数
 * 实现：每次随机选择一个位置和当前的最后一个位置交换（下标）
 * @author Genge
 */
public class FishShuffle {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println("origin=  "+ Arrays.toString(arr));
        shuffle(arr);
        System.out.println("after shuffle= "+Arrays.toString(arr));
    }
    public static void shuffle(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        Random random = new Random();
        for (int i = arr.length - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            swap(arr,i,j);
        }
    }
    private static void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
