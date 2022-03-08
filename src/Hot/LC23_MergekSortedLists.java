package Hot;

import DataStructure.ListNode;

import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-08 10:31
 **/
public class LC23_MergekSortedLists {

    class Status implements Comparable<Status> {
        int val;
        ListNode p;

        Status (int val, ListNode p) {
            this.val = val;
            this.p = p;
        }

        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Status> heap = new PriorityQueue<>();
        int size = lists.length;
        for (int i = 0; i < size; ++i) {
            if (lists[i] != null) {
                heap.offer(new Status(lists[i].val, lists[i]));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!heap.isEmpty()) {
            Status tmp = heap.poll();
            tail.next = tmp.p;
            tail = tail.next;
            if (tmp.p.next != null) {
                heap.offer(new Status(tmp.p.next.val, tmp.p.next));
            }
        }
        return head.next;
    }

    public ListNode mergeKLists_(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }


}
