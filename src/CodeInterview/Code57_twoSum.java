package CodeInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-13 10:11
 **/
public class Code57_twoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[0];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            } else if(left + right > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }

    public static int[][] findContinuousSequence(int target) {
        if(target <= 2) return new int[0][0];
        int left = 1, right = 2;
        int sum = 3;
        List<int[]> list = new ArrayList<>();
        while (right + left <= target) {
            if (sum < target) {
                right++;
                sum += right;
            } else if(sum > target) {
                sum -= left;
                left++;
            } else {
                int[] tmp = new int[right - left + 1];
                for (int i = 0; i < tmp.length; ++i) {
                    tmp[i] = left + i;
                }
                sum -= left;
                left++;
                list.add(tmp);
            }
        }
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int target = 1331;
        System.out.println(Arrays.deepToString(findContinuousSequence(target)));
    }
}
