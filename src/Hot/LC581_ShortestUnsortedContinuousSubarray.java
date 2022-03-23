package Hot;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-23 14:46
 **/
public class LC581_ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        //  O(nlogn) 时间
        int start = 0, end = nums.length - 1;
        int[] back = nums.clone();
        Arrays.sort(back);
        while (start < nums.length && nums[start] == back[start]) {
            ++start;
        }
        while (end >= 0 && nums[end] == back[end]) {
            --end;
        }
        return end < 0 ? 0 : end - start + 1;
    }

    public static int findUnsortedSubarray_(int[] nums) {
        // O(n) 两次遍历 一个栈 O(n)
        Deque<Integer> stk1 = new ArrayDeque<>();
        Deque<Integer> stk2 = new ArrayDeque<>();
        int left = nums.length - 1, right = 0;
        int ptr = 0;
        while (ptr < nums.length) {
            while (ptr < nums.length && (stk1.isEmpty() || nums[ptr] >= nums[stk1.peek()])) {
                stk1.push(ptr);
                ++ptr;
            }
            while (ptr < nums.length && !stk1.isEmpty() && nums[stk1.peek()] > nums[ptr]) {
                int tmp = stk1.pop();
                left = Math.min(left, tmp);
            }
        }

        ptr = nums.length - 1;
        while (ptr >= 0) {
            while (ptr >= 0 && (stk2.isEmpty() || nums[ptr] <= nums[stk2.peek()])) {
                stk2.push(ptr);
                --ptr;
            }
            while (ptr >= 0 && !stk2.isEmpty() && nums[stk2.peek()] < nums[ptr]) {
                int tmp = stk2.pop();
                right = Math.max(right, tmp);
            }
        }

        return right <= left? 0 : right - left + 1;
    }

    public int findUnsortedSubarray_1(int[] nums) {
        // 一次遍历 O(n) O(1)
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        int n = 10;


//        int[] nums = {2};
//        System.out.println(findUnsortedSubarray_(nums));

        int[] nums = new int[n];
        for (int i = 0; i < 1000011; ++i) {
            Random random = new Random();
            for (int j = 0; j < n; ++j) {
                nums[j] = random.nextInt(10);
            }
            if (findUnsortedSubarray_(nums) != findUnsortedSubarray(nums)) {
                System.out.println("error");
                break;
            }
        }
    }

}
