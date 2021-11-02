package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: max depth
 * @author: zr
 * @create: 2021-11-02 16:49
 **/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaxDepth {
    //递归
    public int maxDepth_1(TreeNode root) {
        return getTreeDepth(root);
    }

    public int getTreeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getTreeDepth(root.left), getTreeDepth(root.right)) +1;
    }

    //迭代
    public int maxDepth_2(TreeNode root) {
        int depth = 0, res = depth;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                depth++;
                stack.push(node);
                node = node.left;
            }
            res = Math.max(res, depth);
            node = stack.pop();
            depth--;
            node = node.right;
        }
        return res;
    }
}
