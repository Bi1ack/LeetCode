package LinkedList;

/**
 * @author zr
 * @date 2021.10.30
 */
public class MergeTwoSortedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoListed(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode start = new ListNode(0);
        ListNode head = new ListNode(0, start);
        while (p != null && q != null) {
            if (p.val < q.val) {
                start.next = p;
                p = p.next;
            } else {
                start.next = q;
                q = q.next;
            }
            start = start.next;
        }
        if (p != null) {
            start.next = p;
        }
        if (q != null) {
            start.next = q;
        }
        return head.next.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
