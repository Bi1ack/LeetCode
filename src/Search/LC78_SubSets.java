package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2021-12-26 15:26
 **/
public class LC78_SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        backtrack(res, subSet, nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> subSet, int[] nums, int start){
        res.add(new ArrayList<>(subSet));
        for (int i = start; i < nums.length; ++i) {
            subSet.add(nums[i]);
            backtrack(res, subSet, nums, i + 1);
            subSet.remove(subSet.size() - 1);
        }
    }

    // 包含重复元素
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        Arrays.sort(nums);
        backtrack2(res, subSet, nums, 0);
        return res;
    }

    public static void backtrack2(List<List<Integer>> res, List<Integer> subSet, int[] nums, int start){
        res.add(new ArrayList<>(subSet));
        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            subSet.add(nums[i]);
            backtrack2(res, subSet, nums, i + 1);
            subSet.remove(subSet.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> res = subsets2(nums);
        for (List<Integer> r : res) {
            System.out.println(r);
        }
    }
}
