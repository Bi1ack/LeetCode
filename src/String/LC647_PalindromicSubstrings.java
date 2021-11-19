package String;

/**
 * @program: LeetCode
 * @description: 回文子串
 * @author: zr
 * @date: 2021-11-18 21:17
 **/
public class LC647_PalindromicSubstrings {

    //
    // 中心扩展法
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        // 考虑中心有两种情况
        // 1. 中心一个点 （i, i）
        // 2. 中心两个点  (i, i + 1);
        for (int i = 0; i < 2 * n - 1; i++) {
            int left = i / 2, right = left + i % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
                ++res;
            }
        }
        return res;
    }

    //下面的代码可能更好理解
//    int count = 0;
//    public int countSubstrings(String s) {
//        if (s == null || s.length() == 0) return 0;
//
//        for (int i = 0; i < s.length(); i++) { // i is the mid point
//            extendPalindrome(s, i, i); // odd length;
//            extendPalindrome(s, i, i + 1); // even length
//        }
//
//        return count;
//    }
//
//    private void extendPalindrome(String s, int left, int right) {
//        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            count++; left--; right++;
//        }
//    }

}
