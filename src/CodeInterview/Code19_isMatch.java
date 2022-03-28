package CodeInterview;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-28 10:54
 **/
public class Code19_isMatch {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (check(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i][j - 1];
                    }
                } else {
                    if (check(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    boolean check(String s, String p, int i, int j) {
        if (i == 0) return false;
        if (s.charAt(j - 1) == '.') return true;

        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
