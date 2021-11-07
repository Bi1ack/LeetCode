package Tree;

import DataStructure.TreeNode;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 找到最左下节点
 * @author: zr
 * @date: 2021-11-05 10:34
 **/
public class LC513_FindBottomLeftTreeValue {
    //BFS
    public int findBottomLeftValue(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curLevel = 1;
        int left = root.val;
//        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (map.get(node) != curLevel) {
                left = node.val;
                ++curLevel;
            }
            if (node.left != null) {
                queue.offer(node.left);
                map.put(node.left, curLevel + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                map.put(node.right, curLevel + 1);
            }
        }
        return left;
    }

    //DFS
    int Deep = -1;
    int res = 0;

    public int findBottomLeftValue_rec(TreeNode root) {
        res = root.val;
        find(root, 0);
        return res;
    }

    public void find(TreeNode node, int deep) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (deep > Deep) {
                res = node.val;
                Deep = deep;
            }
        }
        if (node.left != null) find(node.left, deep + 1);
        if (node.right != null) find(node.right, deep + 1);
    }
}
