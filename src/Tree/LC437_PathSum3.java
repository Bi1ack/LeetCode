package Tree;

import DataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: Path Sum Ⅲ
 * @author: zr
 * @date: 2021-11-04 10:54
 **/
public class LC437_PathSum3 {
    private int res = 0;
    //递归
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        getSingleNodeSum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    public void getSingleNodeSum(TreeNode root, int targetSum){
        if (root == null) return;
        if (root.val == targetSum)  ++res;
        getSingleNodeSum(root.left, targetSum - root.val);
        getSingleNodeSum(root.right, targetSum - root.val);
    }

    // 前缀和
    // nodeA = a, nodeB = b, a - b = target, 则节点A，B之间一定有一条路径和等于target
    static Map<Integer, Integer> map = new HashMap<>();
    static int ans;
    public static int pathSum_prefix(TreeNode root, int target) {
        map.put(0, 1);
        ans = 0;
        dfs(root, target, 0);
        return ans;
    }

    public static void dfs(TreeNode root, int t, int curSum) {
        if (root == null) return;
        curSum += root.val;
        ans += map.getOrDefault(curSum - t, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        if (root.left != null) dfs(root.left, t, curSum);
        if (root.right != null) dfs(root.right, t, curSum);
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(10);
        head.left = new TreeNode(5);
        head.right = new TreeNode(-3);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(2);
        head.right.left = null;
        head.right.right = new TreeNode(11);
        head.left.left.left = new TreeNode(3);
        head.left.left.right = new TreeNode(-2);
        head.left.right.right = new TreeNode(1);

        int ans = pathSum_prefix(head, 8);
    }

}
