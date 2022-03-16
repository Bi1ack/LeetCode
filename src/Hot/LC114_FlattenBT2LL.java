package Hot;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-15 09:31
 **/
public class LC114_FlattenBT2LL {
    public void flatten(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node.left != null) {
                if (node.right != null) stack.push(node.right);
                node.right = node.left;
                node.left = null;
                node = node.right;
            }
            if (!stack.isEmpty() && node.right == null) {
                node.right = stack.pop();
            } else {
                node = node.right;
            }
        }

    }

    public void flatten_(TreeNode root) {
        // O(n) O(1)
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }


}
