package CodeInterview.Code;

import DataStructure.ListNode;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-28 10:16
 **/
public class Code24_reverseList {

    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode pre = null;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
        }
        return pre;
    }
}
