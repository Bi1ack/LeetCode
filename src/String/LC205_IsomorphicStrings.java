package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 同构字符串
 * @author: zr
 * @date: 2021-11-18 20:33
 **/
public class LC205_IsomorphicStrings {

    public boolean isomorphic(String s1, String s2) {
        return process(s1, s2) && process(s2, s1);
    }

    public boolean process(String s1, String s2) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            if (!map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), s2.charAt(i));
            } else {
                if (map.get(s1.charAt(i)) != s2.charAt(i)) return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] preIndexOfs = new int[256];
        int[] preIndexOft = new int[256];
        for (int i = 0; i < chars.length; i++) {
            if (preIndexOfs[chars[i]] != preIndexOft[chart[i]]) {
                return false;
            }
            preIndexOfs[chars[i]] = i + 1;
            preIndexOft[chart[i]] = i + 1;
        }
        return true;
    }


}
