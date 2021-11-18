package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @program: LeetCode
 * @description: 有效的字母异位词（每个字符出现次数相同）
 * @author: zr
 * @date: 2021-11-18 19:37
 **/
public class LC242_ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int i = 0; i < map.size(); i++) {
            char c = s.charAt(i);
            if (map1.containsKey(c)){
                if (!Objects.equals(map.get(c), map1.get(c))) return false;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] c1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ++c1[s1.charAt(i) - 'a'];
            --c1[s2.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; i++) {
            if (c1[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        if (isAnagram(s1, s2)) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }

    }
}
