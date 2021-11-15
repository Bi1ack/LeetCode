package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: ···
 * @author: zr
 * @date: 2021-11-15 20:19
 **/
public class LC739_DailyTemperatures {

    public int[] daily(int[] t) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[t.length];
        stack.push(new int[]{t[t.length - 1], 0});
        for (int i = t.length - 2; i >= 0; i--) {
            if (!stack.isEmpty()) {
                if (stack.peek()[0] > t[i]) {
                    stack.push(new int[]{t[i], 1});
                    res[i] = 1;
                    continue;
                }
                while (!stack.isEmpty() && stack.peek()[0] < t[i]) {
                    res[i] += stack.peek()[1];
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(new int[]{t[i], 0});
                } else {
                    ++res[i];
                    stack.push(new int[]{t[i], res[i]});
                }

            }
        }
        return res;
    }

    // 单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }


}
