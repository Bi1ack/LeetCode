package Array;

/**
 * @program: LeetCode
 * @description: 有序数组中元素出现的第一个，最后一个位置
 * @author: zr
 * @date: 2021-11-20 17:06
 **/
public class LC34_FindFirstAndLastPosition {

    // /Algorithm/BinarySearch
    public static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int pos = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                pos = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (pos == -1) {
            return new int[]{-1, - 1};
        } else {
            int start = pos - 1, end = pos + 1;
            while (start >=0 && nums[start] == target) start--;
            while (end < nums.length && nums[end] == target) end++;
            return new int[]{start + 1, end - 1};
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,4,5,6,6,7,8,8,8,9,11,12};
        int[] res = searchRange(arr, 7);
    }
}
