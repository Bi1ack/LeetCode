package Hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-22 10:19
 **/
public class LC448_FIndDisappearedNumber {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        // [4,3,2,7,8,2,3,1]
        int n = nums.length;
        int i = 0;
        while (i < n) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
            ++i;
        }
        List<Integer> ans = new ArrayList<>();
        for (i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        return ans;

    }

    public static List<Integer> findDisappearedNumbers_(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers_(nums));
    }

}
