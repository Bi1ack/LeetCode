package CodeInterview;

import DataStructure.ListNode;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-30 09:46
 **/
public class Code24_ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode p = null, q = head;
        while (q != null) {
            ListNode node = q.next;
            q.next = p;
            p = q;
            q = node;
        }
        return p;
    }

}
