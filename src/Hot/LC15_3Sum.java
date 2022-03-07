package Hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-07 09:53
 **/
public class LC15_3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // a + b + c == 0 不重复
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) return list;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (i > 0 && i < n && nums[i] == nums[i - 1]) {
                ++i;
            }
            int k = n - 1;
            for (int j = i + 1; j < n; ++j) {
                while (j > i + 1 && j < n &&  nums[j] == nums[j - 1]) {
                    ++j;
                }
                while (j < k && nums[j] + nums[k] + nums[i] > 0) {
                    --k;
                }
                if (j >= k) break;
                if (nums[j] + nums[i] + nums[k] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    list.add(tmp);
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> threeSum_ (int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 0, 0, 0, 0, 0, 0};
        List<List<Integer>> list = threeSum(nums);
        System.out.println(list);
    }
}
