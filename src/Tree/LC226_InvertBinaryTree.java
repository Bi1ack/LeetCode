package Tree;

import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description: Given the root of a binary tree, invert the tree, and return its root.
 * @author: zr
 * @date: 2021-11-02 22:21
 **/
public class LC226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        if (root.left != null || root.right != null) {
            swap(root);
        }
        return root;
    }

    public void swap(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
