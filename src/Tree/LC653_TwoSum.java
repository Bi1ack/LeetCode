package Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @program: LeetCode
 * @description: BST找两数之和
 * @author: zr
 * @date: 2021-11-12 10:52
 **/
public class LC653_TwoSum {
    // DFS + HashSet
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int target) {
        return dfs(root, target);
    }

    public boolean dfs(TreeNode root, int target) {
        if (root == null) return false;
        if (set.contains(target - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }
        return dfs(root.left, target) || dfs(root.right, target);
    }

    // BFS
    public boolean findTarget_level(TreeNode root, int k) {
        List< Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public void inorder(TreeNode root, List < Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

}
