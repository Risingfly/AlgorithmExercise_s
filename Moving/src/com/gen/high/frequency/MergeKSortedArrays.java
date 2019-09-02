package com.gen.high.frequency;

import com.gen.leetcode.linknode.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 问题：合并k个有序数组
 * 核心思路：使用最小堆（Java中优先队列），堆顶即为最小元素
 * 实现步骤
 * 1、k个数组主要将数组元素和其所在的行列关联起来，用一个元素类关联
 * 2、使用优先队列，重写比较器
 * 3、初始化队列，将每个数组的头元素加入队列同时统计数组长度
 * 4、当队列不空，则出队并将其加入结果数组中，同时将该元素的下一个元素入队，直至队空
 *
 * 若为k个链表的话，则更容易实现，在出队的时候判断该元素的下一个元素是否为空即可
 * @author Genge
 */
public class MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] m = {{1,3,5,7},{2,4,6},{0,8,9,10,11}};
        MergeKSortedArrays merge = new MergeKSortedArrays();
        int[] res = merge.mergekSortedArrays(m);
        System.out.println("sorted = "+ Arrays.toString(res));
    }

    /**
     * leetcode 23
     *多个有序链表合并
     * @param nodes
     * @return
     */
    private ListNode mergeKSortedNode(ListNode[] nodes){
        if (nodes == null || nodes.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(nodes.length,(a,b)->(a.val - b.val));
        for (ListNode node : nodes){
            if (node != null){
                queue.add(node);
            }
        }
        ListNode tail = dummy;
        while (!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null){
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }
    private Comparator<Element> comparator = new Comparator<Element>() {
        @Override
        public int compare(Element o1, Element o2) {
            return o1.val - o2.val;
        }
    };
    private int[] mergekSortedArrays(int[][] m){
        if (m == null || m.length == 0){
            return new int[0];
        }
        int totalSize = 0;
        Queue<Element> queue = new PriorityQueue<>(m.length,comparator);
        for (int i = 0; i < m.length; i++) {
            if (m[i].length > 0){
                Element elem = new Element(i,0,m[i][0]);
                queue.add(elem);
                totalSize += m[i].length;
            }
        }
        int[] res = new int[totalSize];
        int index = 0;
        while (!queue.isEmpty()){
            Element elem = queue.poll();
            res[index++] = elem.val;
            if (elem.col + 1 < m[elem.row].length){
                elem.col += 1;
                elem.val = m[elem.row][elem.col];
                queue.add(elem);
            }
        }
        return res;
    }
}
class Element{
    public int row;
    public int col;
    public int val;
    public Element(int row,int col,int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}