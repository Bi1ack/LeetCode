package CodeInterview.Code;

import DataStructure.ListNode;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-05-03 09:53
 **/
public class Code27_isPalindrome {

    public boolean isPalindrome(ListNode head) {
        // O(n) O(1)
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null || fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        boolean isOdd = fast.next == null;
        fast = slow.next;
        slow.next = null;
        reverseList(head);
        slow = isOdd ? slow.next : slow;
        if (slow.val != fast.val) slow = slow.next;
        while (slow != null && fast != null) {
            if(slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome_(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

}
