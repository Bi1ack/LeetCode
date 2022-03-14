package Hot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-12 10:06
 **/
public class LC76_MInimumWindowSubstring {

    // 可以用数组表示哈希表，更快
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map = new HashMap<>();

    public String minWindow(String s, String t) {
        // 要求 时间 O(m + n)
        // s = "ADOBECODEBANC", t = "ABC"
        int m = s.length();
        int n = t.length();
        if (m < n) return "";

        for (int i = 0; i < n; ++i) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = -1;
        int len = Integer.MAX_VALUE;
        int L = -1, R = -1;
        while (right < m) {
            ++right;
            if (right < m && map.containsKey(s.charAt(right))) {
                map1.put(s.charAt(right), map1.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    L = left;
                    R = len + left;
                }
                if (map1.containsKey(s.charAt(left))) {
                    map1.put(s.charAt(left), map1.get(s.charAt(left)) - 1);
                }

                ++left;
            }
        }
        return L == -1 ? "" : s.substring(L, R);
    }

    public boolean check () {
        Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Character, Integer> entry =  iter.next();
            Character ch = entry.getKey();
            Integer val = entry.getValue();
            if (map1.getOrDefault(ch, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC76_MInimumWindowSubstring test = new LC76_MInimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(test.minWindow(s, t));


    }

}
