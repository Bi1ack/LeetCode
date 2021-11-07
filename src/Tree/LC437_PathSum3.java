package Tree;

import DataStructure.TreeNode;

/**
 * @program: LeetCode
 * @description: Path Sum Ⅲ
 * @author: zr
 * @date: 2021-11-04 10:54
 **/
public class LC437_PathSum3 {
    private int res = 0;
    //递归
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        getSingleNodeSum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    public void getSingleNodeSum(TreeNode root, int targetSum){
        if (root == null) return;
        if (root.val == targetSum)  ++res;
        getSingleNodeSum(root.left, targetSum - root.val);
        getSingleNodeSum(root.right, targetSum - root.val);
    }

    //前缀和
    //todo
    public int pathSum_prefix(TreeNode root, int targetSum) {
        return res;
    }

}
