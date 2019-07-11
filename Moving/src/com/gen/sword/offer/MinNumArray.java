package com.gen.sword.offer;


import java.util.Comparator;

/**
 * 问题：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 * 核心思路：将对应的字符串转换成 a +""+ b 和 b +""+ a,这种数字进行比较，若
 * 若前者大于后者，则进行交换原数组中对应的数字；首先是最高为数字和每一个位置进行
 * 组合找到最小的，然后次高位和后面的位置进行组合找到最小的，以此类推，则为最小数字
 * @author Genge
 */
public class MinNumArray {
    public String printMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0){
            return "";
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int a = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int b = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (a > b){
                    swap(numbers,i,j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(String.valueOf(numbers[i]));
        }
        return sb.toString();
    }
    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
