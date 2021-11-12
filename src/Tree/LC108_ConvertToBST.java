package Tree;

import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description: 将有序数组转为高度平衡（左右子树高度差不超过1）的二叉搜索树
 * @author: zr
 * @date: 2021-11-11 16:51
 **/
public class LC108_ConvertToBST {
    public TreeNode convertToBST(int[] arr) {
        return dfs(arr, 0, arr.length - 1);
    }

    public TreeNode dfs(int[] arr, int low, int high) {
        if (low <= high) {
            int mid = (high - low)/2 +low;
            TreeNode node = new TreeNode(arr[mid]);
            node.left = dfs(arr, low, mid - 1);
            node.right = dfs(arr, mid + 1, high);
            return node;
        }
        return null;
    }
}
