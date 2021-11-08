package Tree;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC404_SumOfLeftLeaves {
    //BFS
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                } else {
                    queue.offer(node.left);
                }

            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return sum;
    }

    //DFS
    public int sumOfLeftLeaves_rec(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) sum = root.left.val;
        }
        return sum + sumOfLeftLeaves_rec(root.left) + sumOfLeftLeaves_rec(root.right);
    }
}
