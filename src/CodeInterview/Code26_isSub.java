package CodeInterview;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-30 10:56
 **/
public class Code26_isSub {

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = A;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                if (node.val == B.val && dfs(node, B)) {
                    return true;
                }
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return false;
    }

    static boolean dfs(TreeNode root, TreeNode root1) {
        if (root1 == null) {
            return true;
        } else if (root == null) {
            return false;
        } else {
            return root.val == root1.val && dfs(root.left, root1.left) && dfs(root.right, root1.right);
        }

    }

    public boolean isSubStructure_(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return dfs_(A, B) || isSubStructure_(A.left, B) || isSubStructure_(A.right, B);
    }

    boolean dfs_(TreeNode root, TreeNode root1) {
        if (root1 == null) {
            return true;
        } else if (root == null || root.val != root1.val) {
            return false;
        } else {
            return dfs(root.left, root1.left) && dfs(root.right, root1.right);
        }

    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.left.left = new TreeNode(4);
        A.right = new TreeNode(3);

        TreeNode B = new TreeNode(2);

        System.out.println(isSubStructure(A, B));
    }

}
