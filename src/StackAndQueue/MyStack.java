package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 用队列实现栈
 * @author: zr
 * @date: 2021-11-15 17:20
 **/
public class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            q1.offer(x);
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
        } else {
            q1.offer(x);
        }

        // 一个队列
//        int n = queue.size();
//        queue.offer(x);
//        for (int i = 0; i < n; i++) {
//            queue.offer(queue.poll());
//        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
