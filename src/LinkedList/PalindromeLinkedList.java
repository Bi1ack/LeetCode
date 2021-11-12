package LinkedList;

import DataStructure.ListNode;

import java.util.Stack;

/**
 * @author zr
 * @date 2021.10.30
 */
public class PalindromeLinkedList {
    public boolean isPalindrome_stack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        p = head;
        while (!stack.isEmpty()) {
            if (stack.pop().val != p.val) {
                return false;
            }
            p = p.next;
        }
        return true;
    }

    public static boolean isPalindrome_FSPointers(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //反转前半部分
        fast = slow.next;
        slow.next = null;
        ListNode p = fast;
        fast = reverseList(fast);
        p.next = slow;
        slow = head;
        //判断是否回文
        while (slow != null && fast != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
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

    //递归
    private static ListNode first;
    public static boolean isPalindrome(ListNode head) {
        first = head;
        return judge(head);
    }

    public static boolean judge(ListNode cur) {
        if (cur != null) {
            if (!judge(cur.next)) {
                return false;
            }
            if (cur.val != first.val) {
                return false;
            }
            first = first.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(1);
        if (isPalindrome(head)) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}


