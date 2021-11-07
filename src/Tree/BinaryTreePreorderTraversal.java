package Tree;

import DataStructure.TreeNode;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 二叉树迭代遍历
 * @author: zr
 * @create: 2021-11-02 20:17
 **/
public class BinaryTreePreorderTraversal {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }

    public List<Integer> posOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null || node.right == pre) {
                res.add(node.val);
                pre = node;
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
        return res;
    }

    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
//            TreeNode node = root;
            res.add(root.val);
            deque.poll();
            if (root.left != null) {
                deque.add(root.left);
            }
            if (root.right != null) {
                deque.add(root.right);
            }
            root = deque.peekFirst();
        }
        return res;
    }
    //for test

}
