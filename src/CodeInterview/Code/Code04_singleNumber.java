package CodeInterview.Code;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-21 10:19
 **/
public class Code04_singleNumber {

    public static int singleNumber(int[] nums) {
        // 统计每一位上 1 出现的次数
        // 不能被 3 整除则为ans
        // O(nlog32) O(1)
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, -16};
        System.out.println(singleNumber(nums));
    }
}
