package Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC637_AveragesOfLevelsInBinaryTree {
    public List<Double> averagesOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curEnd = root;
        int sum = 0, count = 0;
        TreeNode nextEnd = null;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                nextEnd = node.left;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextEnd = node.right;
            }
            sum += node.val;
            ++count;
            if(node == curEnd) {
                res.add((double) (sum / count));
                sum = 0;
                count = 0;
                curEnd = nextEnd;
                nextEnd = null;
            }

        }
        return res;
    }
}
