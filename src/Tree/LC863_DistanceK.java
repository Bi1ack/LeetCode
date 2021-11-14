package Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC863_DistanceK {

    Map<Integer, TreeNode> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    // 用哈希表记录父节点，对每个节点搜索左孩子，右孩子，父节点三个方向
    // from记录来源节点防止走回路
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);
        find(target, null, 0, k);
        return res;
    }

    public void findParents (TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            map.put(root.left.val, root);
            findParents(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            findParents(root.right);
        }
    }

    public void find (TreeNode node, TreeNode from, int pathLength, int k) {
        if (node == null) return;

        if (pathLength == k) {
            res.add(node.val);
            // 找到就返回，避免多走，浪费时间
            return;
        }

        if (node.left != from) {
            find(node.left, node, pathLength + 1, k);
        }

        if (node.right != from) {
            find(node.right, node, pathLength + 1, k);
        }

        if (map.get(node.val) != from) {
            find(map.get(node.val), node, pathLength + 1, k);
        }
    }

}
