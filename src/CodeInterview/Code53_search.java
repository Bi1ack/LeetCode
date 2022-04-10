package CodeInterview;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-10 11:22
 **/
public class Code53_search {

    public static int search(int[] nums, int target) {
        return binarySearch(nums, target, true) - binarySearch(nums, target, false);
    }

    private static int binarySearch(int[] nums, int target, boolean f) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (f) {
                    // 左
                    right = mid - 1;
                } else {
                    // 右
                    left = mid + 1;
                }
            }
        }
        return f ? left : right;
    }

    public int search_(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

    public int binarySearch_(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,3,4};
        int target = 2;
        System.out.println(binarySearch(nums, target, true));
    }
}
