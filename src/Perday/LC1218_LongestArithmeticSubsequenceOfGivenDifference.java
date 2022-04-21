package Perday;

import java.util.*;

/**
 * @program: LeetCode
 * @description: lc 1218
 * @author: zr
 * @date: 2021-11-07 12:00
 **/
public class LC1218_LongestArithmeticSubsequenceOfGivenDifference {
    public static int longestSubsequence(int[] arr, int difference) {
        // 超时
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 1; i < arr.length; ++i) {
            for(int j = i - 1; j >= 0; --j) {
                if(arr[i] - arr[j] == difference) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    ans = Math.max(ans, dp[i]);
                    break;
                }
            }
        }
        return ans;
    }

    public int longestSubsequence_(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {3,4,-3,-2,-4};
        System.out.println(longestSubsequence(arr, -5));
    }
}
