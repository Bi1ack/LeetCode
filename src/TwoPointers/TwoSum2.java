package TwoPointers;

import java.util.Scanner;

public class TwoSum2 {
    /*
    notes:
    @date: 2021/10/14
     */

    public static int[] twoSum(int[] nums, int target){
        int p = 0, q = nums.length - 1;
        int[] res = new int[2];
        while (p < q) {
            if (nums[p] + nums[q] > target) {
                q--;
            } else if (nums[p] + nums[q] < target) {
                p++;
            } else {
                return new int[]{p+1, q+1};
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] nums = new int[n];
        int target;
        target = in.nextInt();
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] res;
        res = twoSum(nums, target);
        for (int num : res) System.out.print(num);
    }
}

