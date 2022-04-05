package CodeInterview;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-03 11:13
 **/
public class Code36_treeToDoublyList {

    public static TreeNode treeToDoublyList(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        TreeNode pre = null;
        TreeNode head = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (pre != null) {
                pre.right = node;
                node.left = pre;
            } else {
                head = node;
            }
            pre = node;
            node = node.right;
        }
        head.left = pre;
        pre.right = head;
        return head;
    }

    TreeNode pre, head;
    public TreeNode treeToDoublyList_(TreeNode root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(TreeNode cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        int[] pre = {4, 2, 1, 3, 5};
        int[] in = {1, 2, 3, 4, 5};
        root = root.buildTreeByPreIn(pre, in);
        root = treeToDoublyList(root);
    }
}
