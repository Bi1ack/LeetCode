package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zr
 * @date 2021.10.30
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class IntersectionOfTwoLinkedList {
    //for test
    //https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static ListNode getIntersectionNode_HashSet(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode p = headA;
        while (p != null) {
            set.add(p);
            p = p.next;
        }
        p = headB;
        while (p != null && !set.contains(p)) {
            p = p.next;
        }
        return p;
    }

}
