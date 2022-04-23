package CodeInterview.Code;

import java.util.HashMap;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-23 09:56
 **/
public class Code10_subarraySum {

    public static int subArraySum(int[] nums, int target) {
        // 滑动窗口 不能解决有负数的情况
        int sum = 0; // 当前窗口的的和
        int left = 0, right = 0;
        int ans = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                if (sum == target) ++ans;
                sum -= nums[left];
                ++left;
            }
        }
        return ans;
    }

    public static int subArraySum_(int[] nums, int target) {
        // 前缀和 O(n^2) O(1)
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }
        int ans = 0;
        for (int i = 0; i <= nums.length; ++i) {
            for (int j = i + 1; j <= nums.length; ++j) {
                if (prefix[j] - prefix[i] == target)
                    ++ans;
            }
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        // 前缀和 + 哈希表优化 O(n) O(n)
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(subArraySum_(nums, 2));
    }
}
