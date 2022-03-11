package Hot;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-11 10:05
 **/
public class LC55_JumpGame {
    public boolean canJump (int[] arr) {
        int n = arr.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i] = dp[j] & ((i - j) <= arr[j]);
                if (dp[i]) break;
            }
        }
        return dp[n - 1];
    }

    public boolean canJump_(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }


}
