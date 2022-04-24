package CodeInterview.Code;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-24 15:39
 **/
public class Code12_pivotIndex {

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (sum - nums[i] == leftSum * 2)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,-1,-1,-1};
        System.out.println(pivotIndex(nums));
    }
}
