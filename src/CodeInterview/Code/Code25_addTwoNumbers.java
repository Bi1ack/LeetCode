package CodeInterview.Code;

import DataStructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-30 10:30
 **/
public class Code25_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode p = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int s1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int s2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            int sum = (s1 + s2 + carry) % 10;
            carry = (s1 + s2 + carry) / 10;
            ListNode node = new ListNode(sum);
            node.next = p;
            p = node;
        }
        return p;
    }
}
