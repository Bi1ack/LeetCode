package Tree;

import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description: 删除二叉搜索树中的某个节点
 * @author: zr
 * @date: 2021-11-08 13:09
 **/
public class LC450_DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                TreeNode next = successor(root);
                root.val = next.val;
                root.right = deleteNode(root.right, root.val);
            } else {
                TreeNode pre = predecessor(root);
                root.val = pre.val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    public TreeNode successor(TreeNode node) {
        TreeNode n = node.right;
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    public TreeNode predecessor(TreeNode node) {
        TreeNode n = node.left;
        while (n.right != null) {
            n = n.right;
        }
        return n;
    }

}
