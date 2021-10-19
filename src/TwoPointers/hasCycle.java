package TwoPointers;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class hasCycle {
    /**
     * @author zr
     * date 2021.10.19
     */

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode p = head, q = head.next;
        while (p != q) {
            p = p.next;
            if (q.next!= null && q.next.next != null) {
                q = q.next.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(0);
//        h.next.next = new ListNode(2);
//        h.next.next.next = h;
        boolean res = hasCycle(h);
        System.out.print(res);
    }
}
