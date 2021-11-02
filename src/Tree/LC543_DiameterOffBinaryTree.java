package Tree;

/**
 * @program: LeetCode
 * @description: todo
 * @author: zr
 * @date: 2021-11-02 21:55
 **/
public class LC543_DiameterOffBinaryTree {
    int maxd;
    public int diameterOfBinaryTree(TreeNode root) {
        maxd = 0;
        getmaxdia(root);
        return maxd;
    }

    public int getmaxdia(TreeNode root) {
        if (root == null) return 0;
        int left = getmaxdia(root.left);
        int right = getmaxdia(root.right);
        maxd = Math.max(left + right, maxd);
        return Math.max(left, right) + 1;
    }
}
