package LinkedList;

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
            if (stack.pop().val != p.val) {return false;}
            p = p.next;
        }
        return true;
    }

//    public boolean isPalindrome_FSPointers(ListNode head) {
//
//    }
//
//    public boolean isPalindrome(ListNode head) {
//
//    }
}


