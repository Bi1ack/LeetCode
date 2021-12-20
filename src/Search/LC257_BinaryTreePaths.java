package Search;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 二叉树所有路径
 * @author: zr
 * @date: 2021-12-20 21:42
 **/
public class LC257_BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> val = new ArrayList<>();
        dfs(root, res, val);
        return res;
    }

    public static void dfs(TreeNode root, List<String> res, List<Integer> val) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            val.add(root.val);
            StringBuffer s = new StringBuffer();
            for (int i = 0; i < val.size() - 1; ++i) s.append(val.get(i)).append("->");
            s.append(val.get(val.size() - 1));
            res.add(s.toString());
        } else {
            val.add(root.val);
            dfs(root.left, res, val);
            dfs(root.right, res, val);
        }
        val.remove(val.size() - 1);
    }

    // 这样写更好。
    public List<String> binaryTreePaths_(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        List<String> res = binaryTreePaths(root);

    }
}
