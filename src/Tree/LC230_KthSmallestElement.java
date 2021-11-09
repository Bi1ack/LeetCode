package Tree;

import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description: 二叉搜索树第k小的元素
 * @author: zr
 * @date: 2021-11-09 21:12
 **/
public class LC230_KthSmallestElement {
    int res;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        res = -1;
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.left, k);
        ++count;
        if (count == k) {
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
