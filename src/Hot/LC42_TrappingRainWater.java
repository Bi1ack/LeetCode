package Hot;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-10 14:37
 **/
public class LC42_TrappingRainWater {
    public static int trap (int[] arr) {
        if (arr.length <= 2) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int i = 1;
        int ans = 0;
        while (i < arr.length && !stack.isEmpty()) {
            while (i < arr.length && arr[stack.peek()] > arr[i]) {
                stack.push(i);
                ++i;
            }
            if (i == arr.length) break;
            int del = 0;
            int loc = -1;
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                loc = stack.poll();
                if (stack.isEmpty()) break;
                del += (loc - stack.peek()) * arr[loc];
            }
            int tmp = stack.isEmpty()? loc : stack.peek();
            ans += Math.min(arr[i], arr[tmp]) * (i - tmp - 1) - del;
            stack.push(i++);
        }
        return ans;
    }

    public int trap_(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    public int trapDp(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;

    }

    public int trapDP_(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
