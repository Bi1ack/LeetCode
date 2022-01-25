package DP;

/**
 * @program: LeetCode
 * @description: 编辑距离
 * @author: zr
 * @date: 2022-01-25 15:27
 **/
public class LC72_EditDistance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 0; i <= m; ++i) dp[i][0] = i;
        for (int i = 0; i <= n; ++i) dp[0][i] = i;

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(minDistance(s1, s2));
    }
}
