package Perday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2021-12-29 11:12
 **/
public class LC1995_CountSpecialQuadruplets {
    static int ans;
    public static int countQuadruplets(int[] nums) {
        Arrays.sort(nums);
        ans = 0;
        List<Integer> tmp = new ArrayList<>();
        backtraack(nums, tmp, 0);
        return ans;
    }

    public static void backtraack(int[] nums, List<Integer> tmp, int start) {
        if (tmp.size() == 4 && (tmp.get(0) + tmp.get(1) + tmp.get(2)) == tmp.get(3)){
            ans++;
            return;
        }
        if (nums.length - start < 4 - tmp.size()) return;
        for (int i = start; i < nums.length; ++i) {
            tmp.add(nums[i]);
            backtraack(nums, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {53,5,73,91,15,89,67,44,38,22,85,95,36,2,44,7,97,68,2,58,87,68,87,91,36};
        System.out.print(countQuadruplets(nums));
    }

}
