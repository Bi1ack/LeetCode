package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 无重复字符的最大子串
 * @author: Ray
 * @date: 2022-03-12 14:19
 **/
public class LC3_LongestSubstringWithoutRepeatingCharacters {

    public static int length (String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int n = s.length();
        int ans = 0;
        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                ++right;
            }
            ans = Math.max(ans, set.size());
            while (right < n && left < right && set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                ++left;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(length(s));
    }
}
