package CodeInterview.Code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-23 10:43
 **/
public class Code11_findMaxLength {

    public static int findMaxLength(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; ++i) {
            int tmp = nums[i - 1] == 1 ? 1 : -1;
            prefix[i] = prefix[i - 1] + tmp;
        }
        int ans = 0;
        for(int i = 0; i <= nums.length; ++i) {
            for(int j = i + 1; j <= nums.length; ++j) {
                if(prefix[j] - prefix[i] == 0)
                    ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }

    public static int findMaxLength_(int[] nums) {
        Map<Integer, Integer> prefix = new HashMap<>();
        int ans = 0;
        int pre = 0;
        prefix.put(0, -1);
        for(int i = 0; i < nums.length; ++i) {
            int tmp = nums[i] == 1 ? 1 : -1;
            pre += tmp;
            if(prefix.containsKey(pre)) {
                ans = Math.max(ans, i - prefix.get(pre));
            } else {
                prefix.put(pre, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[20];
        for (int i = 0; i < 10; ++i) {
            nums[i] = random.nextInt(2);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(findMaxLength(nums));
    }
}
