package StackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 下一个更大的元素
 * @author: zr
 * @date: 2021-11-15 21:10
 **/
public class LC503_NextGreaterElementⅡ {

    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] ret = new int[n];
        // 数组填充
//        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i % n]) {
                ret[stack.pop()] = arr[i % n];
            }
            if (i < n){
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            ret[stack.pop()] = -1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2, 1};
        int[] res = nextGreaterElements(arr);
    }

}
