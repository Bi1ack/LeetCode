package Hot;

import Algorithm.Sort;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-09 14:46
 **/
public class LC33_SearchInRotatedSortedArray {
    public int search (int[] arr, int target) {
        // log(n)
        if (arr.length == 1) return arr[0] == target? 0 : -1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] >= arr[0]) {
                if (arr[mid] > target && arr[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] < target && arr[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,3};
        LC33_SearchInRotatedSortedArray test = new LC33_SearchInRotatedSortedArray();
        System.out.println(test.search(arr, 3));
    }

}
