package Hot;

import String.LC5_LongestPalindromicSubstring;
/**
 * @program: LeetCode
 * @description: 最长回文子串
 * @author: Ray
 * @date: 2022-03-06 14:55
 **/
public class LC05_LongestPalindromicSubstring {

    /*
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.
     */
    public String longestPalindrome(String s) {
        // 动态规划 n^2 n^2
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public String longestPalindrome1(String s) {
        // 中心扩展法 n^2 1
        // 以 一个点 或者 两个点 为中心 向两边扩展
        String s1 = "";
        for (int i = 0; i < s.length(); ++i) {
            String tmp = process(i, i, s);
            String tmp2 = process(i, i + 1, s);
            s1 = tmp.length() > s1.length() ? tmp : s1;
            s1 = tmp2.length() > s1.length() ? tmp2 : s1;
        }
        return s1;
    }

    String process(int i, int j, String s) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            --i;
            ++j;
        }
        return s.substring(i + 1, j);
    }

    public String longestPalindrome_Manacher(String s) {
        // n 1
        // 字符串预处理
        LC5_LongestPalindromicSubstring test = new LC5_LongestPalindromicSubstring();
        return test.longestPalindrome(s);
    }


    public static void main(String[] args) {
        LC05_LongestPalindromicSubstring test = new LC05_LongestPalindromicSubstring();
        String s = "abdd";
        System.out.println(test.longestPalindrome1(s));

    }
}
