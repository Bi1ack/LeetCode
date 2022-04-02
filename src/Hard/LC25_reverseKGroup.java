package Hard;

import DataStructure.ListNode;
import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-01 14:46
 **/
public class LC25_reverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = head;
        ListNode cur = head;
        ListNode curPre = cur;
        int cnt = 1;
        boolean flag = true;
        while (cur != null) {
            cur = cur.next;
            cnt++;
            if (cnt == k && cur != null) {
                if (flag) {
                    head = reverse(pre, cur.next);
                    cur = curPre.next;
                    flag = false;
                } else {
                    ListNode tmp = curPre.next;
                    curPre.next = reverse(pre, cur.next);
                    cur = tmp.next;
                    curPre = tmp;
                }
                cnt = 1;
                pre = cur;
            }
        }
        return head;
    }

    private static ListNode reverse(ListNode start, ListNode end) {
        ListNode node = start.next;
        ListNode pre = start;
        while (node != end) {
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }
        start.next = end;
        return pre;
    }

    public static void main(String[] args) {
        int[] val = {1,2,3,4,5,6,7,8,9,10,11};
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 1; i < val.length; ++i) {
            p.next = new ListNode(val[i]);
            p = p.next;
        }
        p = reverseKGroup(head, 2);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
