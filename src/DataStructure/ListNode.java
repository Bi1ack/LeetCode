package DataStructure;

/**
 * @program: LeetCode
 * @description: LIst
 * @author: zr
 * @date: 2021-11-12 10:00
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
