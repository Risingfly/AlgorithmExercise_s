package com.gen.test2;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        ReverseArray reverseArray = new ReverseArray();
        reverseArray.InversePairs(arr);
//        System.out.println(reverseArray.InversePairs(arr));
    }
    int count = 0;
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        mergeSortPartition(array,0,array.length - 1);
        return count;
    }
    private void mergeSortPartition(int[] array,int start,int end){
        if (start >= end){
            return ;
        }
        int mid = start + (end - start)/2;
        mergeSortPartition(array,start,mid);
        mergeSortPartition(array,mid + 1,end);
        mergeCount(array,start,mid,end);
    }
    private void mergeCount(int[] array,int start,int mid,int end){
        int i = start,j = mid + 1,k = start;
        int index = start;
        int[] tmp = new int[array.length];
        while (i <= mid && j <= end){
            if (array[i] < array[j]){
                tmp[k++] = array[i++];
            }else{
                tmp[k++] = array[j++];
                //核心代码 若左边数组的数大于右边，则整个左边数组都大于右边
                //因为这俩数组是有序的（归并排序）则当前逆序对就为左边的长度
                count = (count + mid - i + 1) % 1000000007;
            }
            while (i <= mid){
                tmp[k++] = array[i++];
            }
            while (j <= end){
                tmp[k++] = array[j++];
            }
            while (index <= end){
                array[index] = tmp[index];
                index++;
            }
        }
    }
}
