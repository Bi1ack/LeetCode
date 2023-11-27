package Preday;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2023-11-27 20:57
 **/
public class LC01_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }
}
