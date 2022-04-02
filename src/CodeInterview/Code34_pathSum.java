package CodeInterview;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-02 10:36
 **/
public class Code34_pathSum {

    static List<List<Integer>> ans;

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        // 从根节点到叶子节点路径和
        ans = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        dfs(root, target, list);
        return ans;
    }

    private static void dfs(TreeNode root, int target, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (target == root.val && root.left == null && root.right == null)
            ans.add(new LinkedList<>(list));
        dfs(root.left, target - root.val, list);
        dfs(root.right, target - root.val, list);

        list.remove(list.size() - 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        int[] pre = {5, 4, 11, 7, 2, 8, 13, 4, 5, 1};
        int[] in = {7, 11, 2, 4, 5, 13, 8, 5, 4, 1};
        root = root.buildTreeByPreIn(pre, in);
        System.out.println(pathSum(root, 9));
    }


}
