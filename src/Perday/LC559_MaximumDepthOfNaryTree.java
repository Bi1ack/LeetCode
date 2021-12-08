package Perday;

import java.util.ArrayList;
import java.util.List;

public class LC559_MaximumDepthOfNaryTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth1(Node root) {
        // 只针对根节点
        if (root == null) {
            return 0;
        }
        // 叶子节点
        int maxChildDepth = 0;
        List<Node> children = root.children;
        for (Node child : children) {
            int childDepth = maxDepth1(child);
            maxChildDepth = Math.max(maxChildDepth, childDepth);
        }
        return maxChildDepth + 1;
    }


    public int maxDepth(Node root) {
        if (root == null) return 0;
        int[] depth = new int[root.children.size()];
        for (int i = 0; i < root.children.size(); ++i){
            // int[] depth = new int[root.children.size()];
            depth[i] = maxDepth(root.children.get(i));
        }
        return getMax(depth) + 1;
    }

    public int getMax(int[] arr) {
        int max = -1;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int a : list) {
            System.out.println(0);
        }
    }


}
