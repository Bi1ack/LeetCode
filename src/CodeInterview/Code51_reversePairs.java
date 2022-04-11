package CodeInterview;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-11 10:01
 **/
public class Code51_reversePairs {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int ans = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[stack.peek()] > nums[i]) {
                ans += stack.size();
                stack.push(i);
            } else {
                Deque<Integer> s1 = new ArrayDeque<>();
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                    s1.push(stack.pop());
                }
                ans += stack.size();
                stack.push(i);
                while (!s1.isEmpty()) {
                    stack.push(s1.pop());
                }
            }
        }
        return ans;
    }

    static int ans = 0;

    public static int mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    private static void merge(int[] nums, int left, int right, int mid) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
                ans += mid - i + 1;
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        for (i = 0; i < tmp.length; ++i) {
            nums[left + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 7, 9, 5, 4, 3};
        System.out.println(mergeSort(nums));
    }

}
