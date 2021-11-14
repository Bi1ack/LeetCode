package DataStructure;

/**
 * @program: LeetCode
 * @description: 前缀树 / 字典树
 * @author: zr
 * @date: 2021-11-14 11:59
 **/
public class Trie {

    public int val;
    public Trie[] next;

    public Trie () {
        val = 0;
        next = new Trie[26];
    }

}
