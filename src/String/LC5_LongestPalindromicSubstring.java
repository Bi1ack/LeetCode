package String;

/**
 * @program: LeetCode
 * @description: 最长回文子串
 * @author: zr
 * @date: 2021-11-19 21:14
 **/
public class LC5_LongestPalindromicSubstring {

    // 中心扩展法 略

    // DP // TODO: 2021/11/19

    // Manacher
    // O(n) O(n)
    public static String longestPalindrome(String s) {
        // 字符串预处理
        StringBuffer sb = new StringBuffer("#");
        for (int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i)).append("#");
        }
        char[] ch = sb.toString().toCharArray();

        // Manacher
        // 当前最长回文子串的 右边界 和 中心点
        int right = -1;
        int center = -1;
        int res = 0;
        int k = 0;
        int[] p = new int[ch.length];
        for (int i = 0; i < ch.length; ++i) {
            if (i > right) {
                p[i] = extend(ch, i, i);
            } else {
                // 左边界
                int left = 2 * center - right;
                // 点i的中心对称点
                int j = 2 * center - i;
                if (j - p[j] + 1 > left) {
                    p[i] = p[j];
                } else if (j - p[j] + 1 < left) {
                    p[i] = right - i + 1;
                } else {
                    p[i] = extend(ch, right - 2 * (right - i) - 1, right + 1);
                }
            }
            // 一旦出现更右的边界，就更新
            if ((i + p[i] - 1) > right) {
                right = i + p[i] - 1;
                center = i;
            }
            // 记录最长回文子串的中心
            if (p[i] > p[res]) res = i;
        }
        return s.substring((res - p[res] + 1)/2, (res + p[res])/2);
    }

    // 返回回文半径
    public static int extend(char[] ch, int i, int j) {
        while (i >= 0 && j < ch.length && ch[i] == ch[j]) {
            --i;
            ++j;
        }
        return (j - i) / 2;
    }

    public static void main(String[] args) {
        String s = "babadada";
        String ss = longestPalindrome(s);
    }
}
