package CodeInterview;

import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-12 10:06
 **/
public class Code55_maxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
    }

    public boolean isBalanced_(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


}
