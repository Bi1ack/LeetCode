package CodeInterview;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-05 13:37
 **/
public class Code39_majorityElement {

    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                ans = nums[i];
                count++;
            } else {
                if (ans == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return ans;
    }

}
