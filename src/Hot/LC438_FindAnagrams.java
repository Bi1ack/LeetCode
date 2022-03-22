package Hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-22 09:25
 **/
public class LC438_FindAnagrams {

    public static List<Integer> find (String s, String p) {
        // s = "cbaebabacd", p = "abc"
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length())
            return ans;
        int sLen = s.length();
        int pLen = p.length();
        for (int i = 0; i < sLen - pLen + 1; ++i) {
            if (isAna(s.substring(i, i + pLen), p)) {
                ans.add(i);
            }
        }
        return ans;
    }

    static boolean isAna (String s, String p) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            cnt[s.charAt(i) - 'a']++;
            cnt[p.charAt(i) - 'a']--;
        }
        for (int n : cnt) {
            if (n != 0)
                return false;
        }
        return true;
    }

    static List<Integer> findA (String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "acdcaeccde";
        String p = "c";
        System.out.println(findA(s, p));
    }

}
