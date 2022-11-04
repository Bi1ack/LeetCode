package CodeInterview.Code;

import DataStructure.TreeNode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Code52_increasingBST {
    TreeNode ans;
    TreeNode pre = null;
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre == null) {
            ans = root;
            pre = root;
        } else {
            pre.right = root;
            root.left = null;
            pre = root;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];
//        PriorityQueue
        for (int i = 0; i < 10; ++i) {
            nums[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(nums));
    }
}
