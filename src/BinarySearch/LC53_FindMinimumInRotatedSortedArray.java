package BinarySearch;

/**
 * @program: LeetCode
 * @description: 查找旋转数组的最小元素
 * @author: zr
 * @date: 2021-12-04 14:54
 **/
public class LC53_FindMinimumInRotatedSortedArray {

    public int find(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= arr[high]) {
                high = mid;
            } else if (arr[mid] > arr[high]) {
                low = mid + 1;
            }
        }
        return arr[low];
    }

}
