package com.gen.sword.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * 问题：按之字打印二叉树
 * @author Genge
 */
public class ZigZagPLringBinaryTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null){
            return ret;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(null);
        queue.addLast(pRoot);
        boolean leftToRight = true;

        while (queue.size() != 1){
            TreeNode node = queue.removeFirst();
            if (node == null){
                Iterator<TreeNode> iterator = null;
                if (leftToRight){
                    iterator = queue.iterator();
                }else {
                    iterator = queue.descendingIterator();
                }
                leftToRight = !leftToRight;
                while (iterator.hasNext()){
                    TreeNode tmp = (TreeNode)iterator.next();
                    list.add(tmp.val);
                }
                ret.add(new ArrayList<>(list));
                list.clear();
                queue.addLast(null);
                continue;
            }
          if (node.left != null){
                queue.addLast(node.left);
          }
          if (node.right != null){
                queue.addLast(node.right);
          }
        }
        return ret;
    }
}
