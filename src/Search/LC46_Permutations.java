package Search;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2021-12-21 17:05
 **/
public class LC46_Permutations {

    // 无重复数
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // boolean[] selected =  new boolean[nums.length];
        Map<Integer, Boolean> selected = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            selected.put(nums[i], false);
        }
        List<Integer> tmp = new ArrayList<>();

        backtrack(nums, res, tmp, selected);

        return res;
    }

    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tmp, Map<Integer, Boolean> selected) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<Integer>(tmp));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (!selected.get(nums[i])) {
                    tmp.add(nums[i]);
                    selected.put(nums[i], true);
                    backtrack(nums, res, tmp, selected);
                    selected.put(nums[i], false);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    // 有重复数
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] selected =  new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();

        backtrack_(nums, res, tmp, selected);

        return res;
    }

    public static void backtrack_(int[] nums, List<List<Integer>> res, List<Integer> tmp, boolean[] selected) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<Integer>(tmp));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (!selected[i] && !(i > 0 && nums[i] == nums[i - 1] && !selected[i - 1])) {
                    tmp.add(nums[i]);
                    selected[i] = true;
                    backtrack_(nums, res, tmp, selected);
                    selected[i] = false;
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3,1};
        Arrays.sort(nums);
        List<List<Integer>> res = permuteUnique(nums);
    }

}
