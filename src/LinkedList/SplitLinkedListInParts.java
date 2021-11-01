package LinkedList;

/**
 * @author zr
 * @date 2021.11.1
 */
public class SplitLinkedListInParts {
    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode p = head;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        int len = n / k;
        //优化 ： 通过余数计算有几个元素应该加1
//        int remain = n % k;
        int[] arrlen = new int[k];
        if (len * k == n) {
            for (int i = 0; i < k; i++) {
                arrlen[i] = len;
            }
        } else {
            int extra = n - len * k;
            for (int i = 0; i < extra; i++) {
                arrlen[i] = len + 1;
            }
            for (int i = extra; i < k; i++) {
                arrlen[i] = len;
            }
        }
        ListNode[] res = new ListNode[k];
        p = head;
        for (int i = 0; i < k && p != null; i++) {
            int l = arrlen[i];
//            if (l == 0) {
//                res[i] = null;
//                continue;
//            }
            ListNode tmp = p;
            ListNode pre = p;
            while (l-- > 0) {
                pre = p;
                p = p.next;
            }
//            p = p.next;
            pre.next = null;
            res[i] = tmp;
        }
        return res;
    }
}
