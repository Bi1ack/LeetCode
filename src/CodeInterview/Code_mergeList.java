package CodeInterview;

import DataStructure.ListNode;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-30 10:33
 **/
public class Code_mergeList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 == null? l2 : l1;
        return head.next;
    }

    public static ListNode constructList(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < nums.length; ++i) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 2, 4};
        int[] n2 = {1, 3, 4};
        ListNode l1 = constructList(n1);
        ListNode l2 = constructList(n2);
        ListNode node = mergeTwoLists(l1, l2);
    }

}
