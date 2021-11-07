package Tree;

import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description: 最长同值路径
 * @author: zr
 * @date: 2021-11-07 12:15
 **/
public class LC687_LongestUnivaluePath {
    int path;
    public int longestUnivaluePath(TreeNode root) {
        path = 0;
        dfs(root);
        return path;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
//        int leftPath = 0, rightPath = 0;
//        if (node.left != null && node.left.val == node.val) {
//            leftPath += left + 1;
//        }
//        if (node.right != null && node.right.val == node.val) {
//            rightPath += right + 1;
//        }
//        path = Math.max(path, leftPath + rightPath);
//        return Math.max(leftPath, rightPath);
        if (node.left != null && node.left.val == node.val) {
            left++;
        } else {
            left = 0;
        }
        if (node.right != null && node.right.val == node.val) {
            right++;
        } else {
            right = 0;
        }
        path = Math.max(path, left + right);
        return Math.max(left, right);
    }
}
