package CodeInterview;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-01 14:26
 **/
public class Code32_levelOrder {

    public int[] levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int[] ans = new int[1001];
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                ans[cnt++] = node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return Arrays.copyOf(ans, cnt);
    }
}
