package StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 下一个更大元素
 * @author: zr
 * @date: 2021-11-15 22:17
 **/
public class LC496_NextGreaterElement {

    // arr1 = [4,1,2], arr2[2] = [1, 3, 4, 2]
    public int[] nextGreaterElement(int[] arr1, int[] arr2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[arr1.length];
        for (int i = arr2.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr2[i] >= stack.peek()) {
                stack.pop();
            }
            map.put(arr2[i], stack.isEmpty()? -1 : stack.peek());
            stack.push(arr2[i]);
        }

        for (int i = 0; i < res.length; ++i) {
            res[i] = map.get(arr1[i]);
        }
        return res;
    }

}
