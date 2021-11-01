package LinkedList;

import java.util.Stack;

/**
 * @author zr
 * @date 2021.10.30
 */
public class ReverseLinkedList {

    public ListNode reverseList_stack(ListNode head) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        head = stack.pop();
        p = head;
        while (!stack.isEmpty()) {
            p.next = stack.pop();
        }
        p.next = null;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode p = head, q;
        while (p != null) {
            q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
        return pre;
    }
}
