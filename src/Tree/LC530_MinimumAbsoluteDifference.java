package Tree;

import DataStructure.TreeNode;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 最小绝对差
 * @author: zr
 * @date: 2021-11-12 14:23
 **/
public class LC530_MinimumAbsoluteDifference {

    // 中序遍历两个相邻节点的最小差值
    // DFS
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    //
    public int mini(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> s1 = new Stack<>();
        TreeNode node = root;
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (!stack.isEmpty() && !s1.isEmpty()) {
                min = Math.min(min, Math.abs(node.val - s1.pop().val));
            }
            s1.push(node);
            node = node.right;
        }
        return min;
    }


}
