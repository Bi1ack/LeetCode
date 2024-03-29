package CodeInterview.Code;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-27 15:40
 **/
public class Code20_countSubstrings {

    private int ans = 0;
    public int countSubstrings(String s) {
        count(s, 0, 0);
        for (int i = 1; i < s.length(); ++i) {
            count(s, i, i);
            count(s, i - 1, i);
        }
        return ans;
    }

    // 以 left 和 right 为回文中心，向左右扩展
    private void count(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left--) == s.charAt(right++)) {
                ++ans;
                continue;
            }
            return;
        }
    }

    public int countSubstrings_(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

    // O(n) O(n)
    public int countSubstringsManacher(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }



    public static void main(String[] args) {
        String s = "aaa";
        Code20_countSubstrings test = new Code20_countSubstrings();
        System.out.println(test.countSubstrings(s));
    }
}
