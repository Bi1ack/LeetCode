package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 判断一个棵树是否镜像
 * @author: zr
 * @date: 2021-11-05 09:33
 **/
public class LC101_SymmetricTree {
    //递归 O(n)
    public boolean isSymmetric(TreeNode root) {
        return subsIsSymmetric(root.left, root.right);
    }

    public boolean subsIsSymmetric(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return n1.val == n2.val && subsIsSymmetric(n1.left, n2.right) && subsIsSymmetric(n1.right, n2.left);
    }

    //迭代 O(n)
    public boolean isSymmetric_queue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;
            queue.offer(n1.left);
            queue.offer(n2.right);
            queue.offer(n1.right);
            queue.offer(n2.left);
        }
        return true;
    }

}
