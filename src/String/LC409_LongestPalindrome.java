package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 最长回文串
 * @author: zr
 * @date: 2021-11-18 20:09
 **/
public class LC409_LongestPalindrome {

    public static int longest(String s) {
        int res = 0;
        boolean flag = false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 == 0) {
                res += val;
            } else {
                if (val > 1) res += (val - 1);
                flag = true;
            }
        }

        return flag ? ++res : res;
    }

    // ascii一共128个
    // 贪心
    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "abccccdd";
        longest(s);
    }

}
