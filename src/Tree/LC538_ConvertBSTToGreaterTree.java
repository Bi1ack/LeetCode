package Tree;

import DataStructure.TreeNode;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 所有结点加上树中比他大的zhi
 * @author: zr
 * @date: 2021-11-09 22:00
 **/
public class LC538_ConvertBSTToGreaterTree {
    //反向中序
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node  = root;
        int sum = 0;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            node.val = node.val + sum;
            sum += node.val;
            node = node.left;
        }
        return root;
    }

    //递归
    int sum = 0;

    public TreeNode convertBST_rec(TreeNode root) {
        if (root != null) {
            convertBST_rec(root.right);
            sum += root.val;
            root.val = sum;
            convertBST_rec(root.left);
        }
        return root;
    }

}
