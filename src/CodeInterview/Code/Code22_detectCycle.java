package CodeInterview.Code;

import DataStructure.ListNode;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-28 09:49
 **/
public class Code22_detectCycle {

    public static ListNode detectCycle(ListNode head) {
        // 哈希表

        // 快慢指针
        if (head == null || head.next == null || head.next.next == null) return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (slow != fast && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public ListNode detectCycle_(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
