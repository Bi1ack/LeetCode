package Tree;

import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description: 最近公共祖先二叉树
 * @author: zr
 * @date: 2021-11-09 22:47
 **/
public class LC236_lowestCommonAncestor2 {

    public TreeNode lowest(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowest(root.left, p, q);
        TreeNode right = lowest(root.right, p, q);
        if (left != null && right != null) {
             return root;
         } else {
             return left == null? right : left;
         }
    }
}
