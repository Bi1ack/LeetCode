package Tree;


import DataStructure.Trie;

/**
 * @program: LeetCode
 * @description: 实现字典树
 * @author: zr
 * @date: 2021-11-14 12:10
 **/
public class LC208_Trie {
    public class Node {
        Node[] next = new Node[26];
        boolean isLeaf;
    }

    private Node root = new Node();
    private Node node = root;
    public LC208_Trie () {

    }

    public void insert (String word) {
        node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Node();
            }
            node = node.next[c - 'a'];
        }
        node.isLeaf = true;
    }

    public boolean search (String word) {
        node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) return false;
            node = node.next[c - 'a'];
        }
        return node.isLeaf;
    }

    public boolean startsWith (String prefix) {
        node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) return false;
            node = node.next[c - 'a'];
        }
        return true;
    }
}
