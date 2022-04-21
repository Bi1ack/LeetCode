package CodeInterview.Code;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-21 11:04
 **/
public class Code06_twoSum {

    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        while(left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left, right};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
