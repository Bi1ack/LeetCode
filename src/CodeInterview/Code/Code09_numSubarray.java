package CodeInterview.Code;

/**
 * @program: LeetCode
 * @description: 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 * @author: Ray
 * @date: 2022-04-22 10:24
 **/
public class Code09_numSubarray {

    public static int numSubarray(int[] nums, int k) {
        int left = 0, right = 0;
        int pro = 1;
        int ans = 0;
        while (right < nums.length) {
            pro *= nums[right];
            while (pro >= k && left <= right) {
                pro /= nums[left++];
            }
            ans += right - left + 1;
            ++right;
        }
        return ans;
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {10, 5, 20, 6, 8, 10, 13, 7, 9, 21};
        System.out.println(numSubarrayProductLessThanK(nums, 130));
        System.out.println(numSubarray(nums, 130));
    }
}
