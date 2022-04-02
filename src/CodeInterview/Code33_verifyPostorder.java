package CodeInterview;

import DataStructure.TreeNode;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-02 09:44
 **/
public class Code33_verifyPostorder {

    public static boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        return dfs(postorder, 0, n - 1);
    }

    private static boolean dfs(int[] postorder, int start, int end) {
        if (end - start <= 1)
            return true;
        int i = start;
        while (i < end && postorder[i] < postorder[end]) {
            ++i;
        }
        int index = i - 1;
        for (; i < end; ++i) {
            if (postorder[i] < postorder[end])
                return false;
        }
        return dfs(postorder, start, index) && dfs(postorder, index + 1, end - 1);
    }

    public boolean verifyPostorder_(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        // 根 -> 右 -> 左
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            // 左子树上的节点，弹栈 找到自己的父节点，同时往后所有的节点值都应该比父节点小 （左边所有节点值都应该更小）
            while (!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            // 根 -> 右 压栈 从小到大
            stack.add(postorder[i]);
        }
        return true;
    }


    public static void main(String[] args) {
//        int[] post = new int[6];
//        Random random = new Random();
//        for (int i = 0; i < 6; i++) {
//            post[i] = random.nextInt(10);
//        }
        int[] post = {1, 3, 2, 9, 8, 7, 5};
        System.out.println(Arrays.toString(post));
        System.out.println(verifyPostorder(post));
    }
}
