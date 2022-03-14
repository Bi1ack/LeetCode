package Hot;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-14 09:28
 **/
public class LC84_LargestRec {
    public static int largest (int[] arr) {
        // 单调栈 xiao -> da
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        Arrays.fill(right, arr.length);
        for (int i = 0; i < arr.length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty()? -1 : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < arr.length; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,4};
        System.out.println(largest(arr));
    }

}
