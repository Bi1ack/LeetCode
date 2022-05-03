package CodeInterview.Code;

import DataStructure.ListNode;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-28 09:30
 **/
public class Code21_removeNthFromEnd {

    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode first = head, second = head;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        ListNode pre = second;
        while (first != null) {
            first = first.next;
            pre = second;
            second = second.next;
        }
        pre.next = second.next;
        return second == head ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(0);
        System.out.println(n1 == n2);
        System.out.println(n1.equals(n2));
    }
}
