package Tree;

import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description: 节点值在[low, high]之间的数值和
 * @author: zr
 * @date: 2021-11-15 09:34
 **/
public class LC938_RangeSum {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
