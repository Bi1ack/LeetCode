package Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: zhongshu
 * @author: zr
 * @date: 2021-11-12 15:46
 **/
public class LC501_FindMode {

    Map<Integer, Integer> map = new HashMap();
    public int[] findMode1(TreeNode root) {
        dfs1(root);
        int max = -1;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void dfs1(TreeNode root) {
        if (root == null) return;
        dfs1(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs1(root.right);
    }

    //
    List<Integer> answer = new ArrayList<Integer>();
    int base, count, maxCount; //初始化默认值为0

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void dfs(TreeNode o) {
        if (o == null) {
            return;
        }
        dfs(o.left);
        update(o.val);
        dfs(o.right);
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

}
