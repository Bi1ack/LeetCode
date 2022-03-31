package CodeInterview;

import DataStructure.TreeNode;


/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-31 10:19
 **/
public class Code28_isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);

    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
