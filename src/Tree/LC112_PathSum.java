package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: path sum
 * @author: zr
 * @date: 2021-11-04 09:38
 **/
public class LC112_PathSum {
    //后序遍历，维护一个sum栈，与stack同时push，pop
    public static boolean hasPathSum_pos(TreeNode root, int targetSum) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sum = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                int tmp = sum.isEmpty() ? 0 : sum.peek();
                sum.push(tmp + node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            int tmp = sum.pop();
            if (node.right == null && node.left == null) {
                if (tmp == targetSum) return true;
            }
            if (node.right == null || node.right == pre) {
                pre = node;
                node = null;
            } else {
                stack.push(node);
                sum.push(tmp);
                node = node.right;
            }
        }
        return false;
    }

    //递归
    public static boolean hasPathSum_rec(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum_rec(root.left, targetSum - root.val) || hasPathSum_rec(root.right, targetSum - root.val);
    }

    //层次遍历
    public static boolean hasPathSum_level(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sum = new LinkedList<>();
        queue.offer(root);
        sum.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int tmp = sum.poll();
            if (node.left == null && node.right == null) {
                if (tmp == targetSum) return true;
            }
            if (node.left != null) {
                queue.offer(node.left);
                sum.offer(tmp + node.left.val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                sum.offer(tmp + node.right.val);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        int targetSum = 7;
        if (hasPathSum_pos(head, targetSum)) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
