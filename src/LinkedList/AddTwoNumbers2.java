package LinkedList;


import java.util.Stack;

/**
 * @author zr
 * @date 2021.10.30
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers_stack(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode p = l1, q = l2;
        while (p != null) {
            stack1.push(p);
            p = p.next;
        }
        while (q != null) {
            stack2.push(q);
            q = q.next;
        }
        ListNode head = new ListNode(0);
//        ListNode start = new ListNode(0, head);
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop().val;
            int b = stack2.isEmpty() ? 0 : stack2.pop().val;
            int sum = a + b + carry;
//            int sum = stack1.pop().val + stack2.pop().val + carry;

            ListNode temp = new ListNode(sum % 10);
            temp.next = head.next;
            head.next = temp;
            carry = sum / 10;
        }
        return head.next;
    }
}
