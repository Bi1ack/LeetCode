package DP;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-22 11:12
 **/
public class LC494_TargetSum {

    public int finTargetSum(int[] nums, int target) {
        //
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        // (sum - neg) - neg = target
        if ((sum - target) % 2 != 0 || (sum - target) < 0) return 0;
        int neg = (sum - target) / 2;

        // 选取若干个数， 使其和为neg
        int[][] dp = new int[nums.length + 1][neg + 1];

        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j <= neg; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }

//        int[] dp = new int[neg + 1];
//        dp[0] = 1;
//        for (int num : nums) {
//            for (int j = neg; j >= num; j--) {
//                dp[j] += dp[j - num];
//            }
//        }


        return dp[nums.length][neg];

    }

}
