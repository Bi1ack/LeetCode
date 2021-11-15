package StackAndQueue;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: lc 155
 * @author: zr
 * @date: 2021-11-15 19:54
 **/
public class MinStack {
    Stack<Integer> s1;
    // 辅助栈
    Stack<Integer> s2;

    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int val) {
        if (!s1.isEmpty()) {
            s1.push(val);
            if (s2.peek() > val) {
                s2.push(val);
            } else {
                s2.push(s2.peek());
            }
        } else {
            s1.push(val);
            s2.push(val);
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }

    // 不用额外空间
    // 每次push一个数组
    Stack<int[]> s3 = new Stack<>();
    public void push1(int val) {
        if (!s3.isEmpty()) {
            s3.push(new int[]{val, val});
        } else {
            s3.push(new int[]{val, Math.min(val, s3.peek()[0])});
        }
    }

    public void pop1() {
        s3.pop();
    }

    public int top1() {
        return s3.peek()[0];
    }

    public int getMin1() {
        return s3.peek()[1];
    }

}
