package Tree;

import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description: 判断是否是平衡二叉树
 * @author: zr
 * @date: 2021-11-02 21:21
 **/
public class LC110_BalancedBinaryTree {
    //自顶向下 O(n^2)
    //重复计算子树的高度
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    //自底向上 O(n)
    //如果遇到子树不是平衡二叉树，直接返回-1.
    public boolean isBalanced_1(TreeNode root) {
        return getDepth_1(root) > 0;
    }

    public int getDepth_1(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth_1(root.left);
        int right = getDepth_1(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(getDepth_1(root.left),getDepth_1(root.right)) + 1;
        }
    }
}
