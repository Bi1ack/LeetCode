package Tree;

import DataStructure.TreeNode;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: BST
 * @author: zr
 * @date: 2021-11-08 10:29
 **/
public class LC669_TrimABinarySearchTree {
    public TreeNode trimBST_rec (TreeNode root, int low, int high) {
        if (root == null) return root;
        if (root.val < low) return trimBST_rec(root.right, low, high);
        if (root.val > high) return trimBST_rec(root.left, low, high);
        //root在[low, high]
        root.left = trimBST_rec(root.left, low, high);
        root.right = trimBST_rec(root.right, low, high);
        return root;
    }

}
