package LinkedList;

/**
 * @author zr
 * @date 2021.11.1
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode tmp = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = odd.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = tmp;
        return head;
    }
}
