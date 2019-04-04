package com.gen.sword.offer;


import java.util.LinkedList;
import java.util.Queue;

/***
 *
 * 问题：序列化和反序列化二叉树
 * @author Genge
 */
public class SerializeTree {

//    先序遍历进行
    String Serialize(TreeNode root) {
        if (root == null){
            return "#!";
        }
        String res = root.val + "!";
        Serialize(root.left);
        Serialize(root.right);
        return res;
    }
    TreeNode Deserialize(String str) {
        String[] values = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i != values.length ; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }
    TreeNode reconPreOrder(Queue<String> queue){
        String val = queue.poll();
        if (val.equals("#")){
            return new TreeNode(0);
        }
        TreeNode head = new TreeNode(Integer.valueOf(val));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
