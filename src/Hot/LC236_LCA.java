package Hot;

import DataStructure.TreeNode;


/**
 * @program: LeetCode
 * @description: 二叉树的最近公共祖先
 * @author: Ray
 * @date: 2022-03-17 15:19
 **/
public class LC236_LCA {
    TreeNode ans = null;

    void dfs(TreeNode root, TreeNode p, TreeNode q) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
}
