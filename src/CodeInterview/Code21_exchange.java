package CodeInterview;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-29 11:22
 **/
public class Code21_exchange {

    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] % 2 == 0) {
                swap(nums, left, right);
                --right;
            } else {
                ++left;
            }
        }
        return nums;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
