package CodeInterview;

import javax.crypto.Mac;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: /
 * @author: Ray
 * @date: 2022-04-08 10:46
 **/
public class Code48_lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int maxLen = 0;
        while (j < s.length()) {
            if (!set.add(s.charAt(j))) {
                maxLen = Math.max(maxLen, j - i);
                while (s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i));
                    ++i;
                }
                ++i;
            }
            ++j;
        }
        return Math.max(set.size(), maxLen);
    }

    public static void main(String[] args) {
        String s = "pwa";

        System.out.println(lengthOfLongestSubstring(s));
    }
}
