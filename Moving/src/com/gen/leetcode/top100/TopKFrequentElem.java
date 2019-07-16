package com.gen.leetcode.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 问题：347
 * 思路:桶排序 第一步,用map统计每个数字出现的次数,
 * 第二步,将出现的次数作为桶下标(最多有数组长度个桶),
 * 第三步,将桶装入对应出现的次数(出现次数相同的桶会放到同一个桶),
 * 第四步,从桶中倒出元素(数字),数量到达k时即满足要求
 *
 * 桶可以用list实现
 * $$$$开辟桶数组的时候谨记,长度为nums.length + 1,因为数组从0开始,若全部
 * 出现则出现了nums.length次,故而要 +  1
 *
 * @author Genge
 */
public class TopKFrequentElem {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        TopKFrequentElem top = new TopKFrequentElem();
        System.out.println(top.topKFrequent(arr,2));
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
//        统计数字出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else {
                map.put(nums[i],1);
//                map.getOrDefault(i,0)
            }
        }
//        开辟桶，将数字出现的次数作为桶下标，数字作为值
//        元素最多出现nums.length次,即只有一个元素,且数组从0开始故加1
        List<Integer>[] bucket = new List[nums.length + 1];
//        map的key为出现的数字，value为次数
        for (int key: map.keySet()) {
//            获取出现的次数作为桶的下标
            int frequency = map.get(key);
//            若桶为空则开辟一个
            if (bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
//            将次数作为下标的桶，装入对应的数字
            bucket[frequency].add(key);
        }
//        倒序（因为下标反应的是出现的频率），
//        从高频率的开始加入到list中，当其中元素满足k时
//        即可退出,这其中的元素即为k个高频元素
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0 ; i--) {
//            将桶中的元素加入到结果中
            if (bucket[i] != null){
                res.addAll(bucket[i]);
            }
//            当满足k个时即可
            if (res.size() >= k){
                break;
            }
        }
        return res;
    }
}
