package LinkedList;

/**
 * @author zr
 * @date 2021.10.30
 */
class ListNode {
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
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head.next);
        ListNode p = head, q = head.next;
        while (q != null) {
            p.next = q.next;
            q.next = p;
            if (p.next == null) break;
            ListNode tmp = p;
            p = p.next;
            q = p.next;
            if (q != null) {
                tmp.next = q;
            }
        }
        return dummy.next;
    }

    public ListNode swapPairs_(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
