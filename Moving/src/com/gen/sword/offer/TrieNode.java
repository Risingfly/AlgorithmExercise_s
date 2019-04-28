package com.gen.sword.offer;

/**
 * 字典树
 * @author Genge
 */
public class TrieNode {
    /**
     * 表示有多少个单词共用这个节点
     */
    public int path;
    /**
     *表示有多少个单词以这个节点结尾
     */
    public int end;
    /**
     * key代表该节点的一条字符路径
     * value代表字符路径指向的节点
     */
    public TrieNode[] map;
    public TrieNode(){
        path = 0;
        end = 0;
        map = new TrieNode[26];
    }
}
