package CodeInterview;

import DataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-25 10:49
 **/
public class Code06_ReversePrint {

    public int[] reverse (ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[list.size() - i - 1] = list.get(i);
        }
        return ans;
    }

}
