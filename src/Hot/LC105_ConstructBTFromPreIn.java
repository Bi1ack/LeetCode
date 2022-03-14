package Hot;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 先序序列和中序序列构造二叉树
 * @author: Ray
 * @date: 2022-03-14 14:48
 **/
public class LC105_ConstructBTFromPreIn {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int inorderIndex = 0;

        for (int i = 1; i < preorder.length; ++i) {
            TreeNode node = stack.peek();
            int preVal = preorder[i];
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preVal);
                stack.push(node.right);
            }
        }
        return root;

    }


    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
    public TreeNode build (int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1);
    }

    TreeNode dfs (int[] preorder, int left, int right) {
        if (left > right)
            return null;
        int rootVal = preorder[index++];
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = map.get(rootVal);
        root.left = dfs(preorder, left, inorderIndex - 1);
        root.right = dfs(preorder, inorderIndex + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        LC105_ConstructBTFromPreIn test = new LC105_ConstructBTFromPreIn();
        test.build(preorder, inorder);
    }

}
