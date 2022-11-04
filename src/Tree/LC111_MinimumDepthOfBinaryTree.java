package Tree;


import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: zr
 * @date: 2021.11.6
 */
public class LC111_MinimumDepthOfBinaryTree {

    public int minDepth_rec(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth_rec(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth_rec(root.right), min);
        }

        return min + 1;
    }

    public int minDepth(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.left == null && root.right == null) {
                min = Math.min(stack.size() + 1, min);
            }
            if (root.right == null || root.right == pre) {
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return min;
    }

    //BFS
    public int minDepth_level (TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curLevel = 0;
        while (!queue.isEmpty()) {
            curLevel++;
            int levelNodes = queue.size();
            for (int i = 0; i < levelNodes; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return curLevel;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return 0;
    }


}
