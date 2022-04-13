package CodeInterview;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-12 09:45
 **/
public class Code54_kthLargest {

    static int ans = -1;
    static int k;

    public static int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
//        stack.push(root);
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            k--;
            if (k == 0)
                return node.val;
            node = node.left;
        }
        return -1;
    }

    private static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (--k == 0) {
            ans = root.val;
            return;
        }
        dfs(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(kthLargest(root, 1));
        k = 1;
        dfs(root);
        System.out.println(ans);
    }
}
