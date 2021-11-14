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

    // 2021/11/9
    // 如果左子树节点数小于 k - 1，则搜索右子树
    // 如果左子树节点数等于 k - 1， 则node就是结果
    // 如果左子树节点数大于 k - 1，则搜索左子树
    int ans;
    int countNode;
    public int kthSmallest1(TreeNode root, int k) {
        ans = -1;
        dfs1(root, k);
        return ans;
    }

    public void dfs1(TreeNode root, int k) {
        if (root == null) return;
        countNode = 0;
        getSubtreeNodes(root.left);
        if (countNode == k - 1) {
            ans = root.val;
        } else if (countNode < k - 1){
            dfs1(root.right, k - countNode - 1);
        } else {
            dfs1(root.left, k);
        }
    }

    // 得到左子树上节点数量
    public void getSubtreeNodes(TreeNode root) {
        if (root == null) return;
        countNode++;
        getSubtreeNodes(root.left);
        getSubtreeNodes(root.right);
    }

}
