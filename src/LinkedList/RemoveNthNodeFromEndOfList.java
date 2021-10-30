package LinkedList;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnc_stack(ListNode head, int n) {
//        Stack<ListNode> stack = new Stack<ListNode>();
//        while (head != null) {
//            stack.push(head);
//            head = head.next;
//        }
//        ListNode p = new ListNode();
//        while (!stack.isEmpty()) {
//            if (--n == 0) {
//                stack.pop();
//                continue;
//            }
//            ListNode q = stack.pop();
//            q.next = p.next;
//            p.next = q;
//        }
//        return p.next;

        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    public ListNode removeNthFromEnd_twoPointers(ListNode head, int n) {
        ListNode start = new ListNode(0, head);
        ListNode p = start, q = start;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        while (q.next != null) {
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        return start.next;
    }

}
