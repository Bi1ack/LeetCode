package Hot;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-23 10:13
 **/
public class LC560_SubarraySum {

    public static int subarraySum(int[] nums, int k) {
        // 滑动窗口， 不能解决负数的情况
        int left = 0, right = 0;
        int n = nums.length;
        int ans = 0;
        int sum = 0;
        while (right < n) {

            while (right < n && sum < k) {
                sum += nums[right];
                ++right;
            }
            if (sum == k) {
                ++ans;
            }
            sum -= nums[left];
            ++left;
        }
        return ans;
    }

    static int ans;

    public static int subarraySum_(int[] nums, int k) {
        // 爆搜 超时
        ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            backtrack(nums, k, i, 0);
        }

        return ans;
    }

    static void backtrack(int[] nums, int k, int index, int sum) {
        if (index == nums.length)
            return;

        // 找到一个解
        sum += nums[index];
        if (sum == k) {
            ++ans;
        }

        backtrack(nums, k, index + 1, sum);

    }

    public static int sub(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int ans = 0;

        // base case
        dp[0][0] = nums[0];
        if (dp[0][0] == k) ++ans;
        for (int i = 1; i < n; ++i) {
            dp[0][i] = dp[0][i - 1] + nums[i];
            if (dp[0][i] == k) ++ans;
        }

        for(int i = 1; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                dp[i][j] = dp[i][j - 1] + nums[j];
                if (dp[i][j] == k) ++ans;
            }
        }
        return ans;
    }

    public int subarraySum1(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }



    public static void main(String[] args) {
        int[] nums = {1, -2, -3, 2, 1, 1};
        System.out.println(sub(nums, -3));
    }

}
