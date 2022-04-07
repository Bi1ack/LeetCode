package CodeInterview;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-06 17:04
 **/
public class Code37_serializeTree {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        sb.append(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node;
            for (int i = 0; i < size; ++i) {
                node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    sb.append("#");
                    sb.append(node.left.val);
                } else {
                    sb.append("#null");
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    sb.append("#");
                    sb.append(node.right.val);
                } else {
                    sb.append("#null");
                }
            }
        }
        return sb.toString();

    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split("#");
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root;
        if (nodes.length >= 1) {
            root = new TreeNode(Integer.parseInt(nodes[0]));
        } else {
            return null;
        }
        int i = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!nodes[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.left);
            }
            i++;
            if (!nodes[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }


    public static void main(String[] args) {
        Code37_serializeTree test = new Code37_serializeTree();
        TreeNode root = new TreeNode();
        int[] pre = {1,2,3,4,5};
        int[] in = {2,1,4,3,5};
        root = root.buildTreeByPreIn(pre, in);
        String data = test.serialize(root);
        root = test.deserialize(data);
    }

}
