package Tree;


/**
 * @program: LeetCode
 * @description: 判断一棵树是否是另一棵树的子树
 * @author: zr
 * @date: 2021-11-04 16:35
 **/
public class LC572_SubtreeOfAnotherTree {
    private static boolean res = false;
    public static boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null) return false;
        if (root1.val == root2.val) res = res || judge(root1, root2);
        isSubtree(root1.left, root2);
        isSubtree(root1.right, root2);
        return res;
    }

    public static boolean judge(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 == null) || (root2 == null))  {
            return false;
        }
        return root1.val == root2.val && judge(root1.left, root2.left) && judge(root1.right, root2.right);
    }
    //todo
//    public boolean isSubtree(TreeNode root1, TreeNode root2) {
//
//    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(4);
        head.right = new TreeNode(5);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(2);
        head.right.left = null;
        head.right.right = null;
        head.left.left.left = null;
        head.left.left.right = null;
        head.left.right.left = new TreeNode(0);



        TreeNode head1 = new TreeNode(4);
        head1.left = new TreeNode(1);
        head1.right = new TreeNode(2);



        if (isSubtree(head, head1)) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
