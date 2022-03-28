package CodeInterview;

import DataStructure.ListNode;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-28 10:46
 **/
public class Code_deleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        ListNode p = head, q = head.next;
        if (p.val == val) return head.next;
        while (q.val != val) {
            q = q.next;
            p = p.next;
        }
        p.next = q.next;
        return head;
    }
}
