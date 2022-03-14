package Hot;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-14 14:11
 **/
public class LC98_ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs (TreeNode root, long lower, long upper) {
        if (root == null)
            return true;
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return dfs(root.left, lower, root.val) && dfs(root.right, root.val, upper);
    }

    public boolean isValidateBST_inorder (TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        long pre = Long.MIN_VALUE;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node.left != null) {
                stack.push(node.left);
                node = node.left;
            }
            node = stack.pop();
            if (node.val <= pre) {
                return false;
            }
            pre = node.val;
            node = node.right;
        }
        return true;
    }

}
