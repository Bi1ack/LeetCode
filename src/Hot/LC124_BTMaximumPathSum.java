package Hot;

import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-15 10:19
 **/
public class LC124_BTMaximumPathSum {
    static int ans = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    public static int dfs (TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        ans = Math.max(ans, left + right + root.val);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }

}
