package Tree;


import DataStructure.ListNode;
import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description: 有序链表构造BST
 * @author: zr
 * @date: 2021-11-12 09:56
 **/
public class LC109_ConvertSortedListToBST {
    // 快慢指针找链表中点 O(nlogn)
    public ListNode findMidNode(ListNode head, ListNode tail) {
        if (head == tail || head.next == tail) return head;
        ListNode p = head;
        ListNode q = head;
        while (p != tail && p.next != tail) {
            p = p.next.next;
            q = q.next;
        }
        return q;
    }

    public TreeNode dfs(ListNode head, ListNode tail) {
        if (head ==  tail) return null;
        ListNode node = findMidNode(head, tail);
        TreeNode root = new TreeNode(node.val);
        root.left = dfs(head, node);
        root.right = dfs(node.next, tail);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return dfs(head, null);
    }

    // 中序遍历优化 O(n)
    ListNode globalHead;

    public TreeNode sortedListToBST_in(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    // 先中序递归建立树结构，然后递归中遍历list填值，
    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }

    // 另一种思路：
    // 先BFS建树,节点数值用0代替，之后，再DFS填值(中序)

}
