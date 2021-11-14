package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 字典树-键值映射
 * @author: zr
 * @date: 2021-11-14 12:42
 **/
public class LC677_MapSumPairs {
    class TrieNode {
        int val = 0;
        TrieNode[] next = new TrieNode[26];
    }

    TrieNode root;
    Map<String, Integer> map;

    public LC677_MapSumPairs() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert (String key, int val) {
        TrieNode node = root;
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        for (char c : key.toCharArray()) {
            int index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrieNode();
            }
            node = node.next[index];
            node.val += delta;
        }
    }

    public int sum (String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) return 0;
            node = node.next[c - 'a'];
        }
        return node.val;
    }



}
