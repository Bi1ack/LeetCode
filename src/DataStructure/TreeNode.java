package DataStructure;

/**
 * @program: LeetCode
 * @description: Tree Node
 * @author: zr
 * @date: 2021-11-07 10:48
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
