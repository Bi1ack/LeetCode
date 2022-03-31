package CodeInterview;

import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-31 10:12
 **/
public class Code27_mirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        if (root.left != null || root.right != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public TreeNode mirrorTree_(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


}
