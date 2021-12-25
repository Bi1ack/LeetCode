package Search;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2021-12-25 10:25
 **/
public class LC77_Combinations {
    // 20ms
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> com = new ArrayList<>();
        backtrack(res, n, k, com, 0);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, int n, int k, List<Integer> com, int start) {
        if (com.size() == k) {
            res.add(new ArrayList<>(com));
        } else {
            // 这里有大量的没必要的计算
            // e.g. n = 10, k = 8， 在 i > 3 时，已经无解了，后面有大量无意义的计算
            // for (int i = start; i < n; ++i) {
            // 添加剪枝之后，时间同样来到了 1ms
            for (int i = start; i < n - (k - com.size()) + 1; ++i) {
                com.add(i + 1);
                backtrack(res, n, k, com, ++start);
                com.remove(com.size() - 1);
            }
        }
    }

    // 1ms 为什么快这么多？？
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine_(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置 --？
        dfs(cur + 1, n, k);
    }


    public static void main(String[] args) {
        int n = 4, k = 3;
        List<List<Integer>> res = combine(n, k);
        for (List<Integer> r : res) {
            System.out.print(r);
        }
    }
}
