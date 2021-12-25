package Perday;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2021-12-25 10:16
 **/
public class LC1609_EvenOddTree {
    public static boolean isEvenOddTree(TreeNode root) {
        if (root.val % 2 == 0) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Boolean even = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int pre;
            if (even) pre = 0;
            else
                pre = Integer.MAX_VALUE;
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (even) {
                    if (node.val % 2 == 0 || pre >= node.val)
                        return false;
                } else {
                    if (node.val % 2 != 0 || pre <= node.val)
                        return false;
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                pre = node.val;
            }
            even = !even;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);
        System.out.print(isEvenOddTree(root));
    }

}
