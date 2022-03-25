package CodeInterview;

import DataStructure.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-25 10:56
 **/
public class Code07_BuildTree {

    // 方法一：递归 O(n) O(n)
    static Map<Integer, Integer> map;
    static int index;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // digui
        index = 0;
        map = new HashMap<>();
        for (int i = 0; i < preorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1);
    }

    private static TreeNode build(int[] pre, int[] in, int left, int right) {
        if (left > right) return null;

        TreeNode root = new TreeNode(pre[index++]);

        int inorderIndex = map.get(root.val);

        root.left = build(pre, in, left, inorderIndex - 1);
        root.right = build(pre, in, inorderIndex + 1, right);

        return root;
    }

    // 方法二：迭代 O(n) O(n)
    public TreeNode buildTree_(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3 , 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20,  7};

        TreeNode root = buildTree(pre, in);
        System.out.println();
    }

}
