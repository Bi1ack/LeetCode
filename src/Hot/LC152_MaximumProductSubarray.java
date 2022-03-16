package Hot;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-16 10:29
 **/
public class LC152_MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] dp1 = new int[n];
        dp[0] = nums[0];
        dp1[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1] * nums[i], Math.max(dp1[i - 1] * nums[i], nums[i]));
            dp1[i] = Math.min(dp1[i - 1] * nums[i], Math.min(dp[i - 1] * nums[i], nums[i]));
        }
        int ans = 0;
        for (int d : dp) {
            ans = Math.max(ans, d);
        }
        return ans;
    }

    public int maxProduct_(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {2, -3, -2, 4, -3, 3};
        System.out.println(maxProduct(nums));
    }

}
