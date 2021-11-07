package Tree;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 二叉树第二小的节点
 * @author: zr
 * @date: 2021-11-07 16:21
 **/
public class LC671_SecondMinimumNodeInABinaryTree {
    int min;
    int res;
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        res = -1;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        if (res == -1 && node.val > min) {
            res = node.val;
        }
        if (node.val != min && node.val < res) {
            res = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }

    public int level(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int min = root.val;
        int res = -1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (res == -1 && node.val > min) {
                res = node.val;
            }
            if (node.val != min && node.val < res) {
                res = node.val;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res;
    }
}
