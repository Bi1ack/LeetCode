package CodeInterview.Code;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-25 15:38
 **/
public class Code15_findAnagrams {

    public static List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < s2.length(); ++i) {
            cnt[s2.charAt(i) - 'a']++;
        }
        for (int right = 0; right < s1.length(); ++right) {
            int index = s1.charAt(right) - 'a';
            cnt[index]--;
            while(cnt[index] < 0) {
                cnt[s1.charAt(left++) - 'a']++;
            }
            if(right - left + 1 == s2.length())
                ans.add(left);
        }
        return ans;
    }

    public List<Integer> findAnagrams_(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s1 = "cbaebabacd";
        String s2 = "abc";
        System.out.println(findAnagrams(s1, s2));

    }

}
