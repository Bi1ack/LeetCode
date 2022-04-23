package CodeInterview.Code;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-22 09:53
 **/
public class Code08_minSubArrayLen {

    public static int minSubArrayLen(int[] nums, int target) {
        // 滑动窗口
        int sum = 0; // 当前窗口的的和
        int left = 0, right = 0;
        int ans = Integer.MAX_VALUE;
        while (sum >= target || right < nums.length) {
            if (sum < target) {
                sum += nums[right++];
                continue;
            }
            ans = Math.min(ans, right - left);
            sum -= nums[left];
            ++left;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(nums, 4));
    }
}
