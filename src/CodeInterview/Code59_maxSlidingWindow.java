package CodeInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-14 17:02
 **/
public class Code59_maxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 超时
        int left = 0;
        List<Integer> list = new ArrayList<>();
        int maxIndex = 0;
        for (int i = 0; i < k; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        list.add(nums[maxIndex]);
        for (int i = k; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
            left++;
            if (left > maxIndex) {
                maxIndex = left;
                for (int j = left; j <= i; ++j) {
                    if (nums[maxIndex] < nums[j]) {
                        maxIndex = j;
                    }
                }
            }
            list.add(nums[maxIndex]);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    // TODO: 2022/4/16

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
