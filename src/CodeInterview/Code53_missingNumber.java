package CodeInterview;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-11 11:23
 **/
public class Code53_missingNumber {

    public static int missingNumber(int[] nums) {
        // O(logn)
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int missingNumber_(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }


    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(missingNumber(nums));
    }

}
