package CodeInterview;

import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-16 15:51
 **/
public class Code68_lowestCommonAncestor {

    // bst
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val)
            return p;
        if (root.val == q.val)
            return q;
        if ((root.val > p.val && root.val < q.val) ||
                (root.val < p.val && root.val > q.val))
            return root;
        if (root.val > p.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return lowestCommonAncestor(root.right, p, q);
    }

    public TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == q || root == p)
            return root;
        TreeNode left = lowestCommonAncestor_(root.left, p, q);
        TreeNode right = lowestCommonAncestor_(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else {
            return left == null? right : left;
        }
    }
}
