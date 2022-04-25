package CodeInterview.Code;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-25 15:58
 **/
public class Code16_longestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[128];
        int left = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i);
            cnt[index]++;
            while (cnt[index] > 1) {
                cnt[s.charAt(left++)]--;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring_(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring_(s));
    }
}
