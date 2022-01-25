package DP;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2022-01-06 19:42
 **/
public class LC300_LongestIncreasingSubsequence {
    public static int lengthOfLIS (int[] nums) {
        // o(n^2)
        // dp数组的含义 dp[i] == 到 i 这个位置时的最长递增序列
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static int LIS (int[] nums) {
        // note:
        // 贪心 + 二分 o(nlogn)

        // TODO: 2022/1/24
                




        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7,7};
        System.out.println(lengthOfLIS(nums));
    }
}
