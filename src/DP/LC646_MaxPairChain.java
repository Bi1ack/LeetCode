package DP;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2022-01-28 22:08
 **/
public class LC646_MaxPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j){
                if (pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 1;
        for (int d : dp) {
            ans = Math.max(d, ans);
        }
        return ans;
    }

    // 贪心
    public int findLongestChain_(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair: pairs) if (cur < pair[0]) {
            cur = pair[1];
            ans++;
        }
        return ans;
    }
}
