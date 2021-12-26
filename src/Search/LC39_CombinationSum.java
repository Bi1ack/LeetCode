package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2021-12-26 14:17
 **/
public class LC39_CombinationSum {

    // combination sum
    public static List<List<Integer>> combinationSum (int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, combination, candidates, target, 0, 0);

        return res;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> combination, int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            if (sum + candidates[i] > target) {
                continue;
            }
            combination.add(candidates[i]);
            sum += candidates[i];
            backtrack(res, combination, candidates, target, sum, i);
            sum -= candidates[i];
            combination.remove(combination.size() - 1);
        }
    }

    // combination sum 2 -- lc 40
    // without duplicate combinations
    public static List<List<Integer>> combinationSum2 (int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtrack2(res, combination, candidates, visited, target, 0, 0);

        return res;
    }

    public static void backtrack2(List<List<Integer>> res, List<Integer> combination, int[] candidates, boolean[] visited, int target, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            // 下面这样写不用额外的 visited 数组
            // i > start 把所有重复的组合的第一个考虑了， 而 i > 0 则不可行
            // if (sum + candidates[i] > target || (i > start && candidates[i] == candidates[i - 1])) {
            if (sum + candidates[i] > target || (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1])) {
                continue;
            }
            combination.add(candidates[i]);
            sum += candidates[i];
            visited[i] = true;
            backtrack2(res, combination, candidates, visited, target, sum, i + 1);
            visited[i] = false;
            sum -= candidates[i];
            combination.remove(combination.size() - 1);
        }
    }

    // combination sum 3 -- lc 216
    public static List<List<Integer>> combinationSum3 (int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack3(res, combination, k, n, 0, 1);

        return res;
    }

    public static void backtrack3(List<List<Integer>> res, List<Integer> combination, int k, int n, int sum, int start) {
        if (combination.size() == k && sum == n) {
            res.add(new ArrayList<>(combination));
            return;
        }

        if (combination.size() >= k) return;

        for (int i = start; i <= 9; ++i) {
            if (sum + i > n) return;
            combination.add(i);
            sum += i;
            backtrack3(res, combination, k, n, sum, i + 1);
            sum -= i;
            combination.remove(combination.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> res = combinationSum3(3, 7);
        for (List<Integer> r : res) {
            System.out.println(r);
        }
    }
}
