package Tree;

import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description: 最近公共祖先
 * @author: zr
 * @date: 2021-11-09 22:14
 **/
public class LC235_LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public static TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode node;
        if (root.val > p.val && root.val > q.val) {
            node = dfs(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            node = dfs(root.right, p, q);
        } else {
            node = root;
        }
        return node;
    }

    public TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(6);
        head.left = new TreeNode(2);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(0);
        head.left.right = new TreeNode(4);
        head.right.left = null;
        head.right.right = null;
        head.left.left.left = null;
        head.left.left.right = null;
        head.left.right.left = new TreeNode(3);
        head.left.right.right = new TreeNode(5);

        TreeNode node = lowestCommonAncestor(head, head.left, head.left.right);
    }

}
