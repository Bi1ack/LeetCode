package Sorting;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-11 10:37
 **/
public class mergeSort {


    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    private static void merge(int[] nums, int left, int right, int mid) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            tmp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        for (i = 0; i < tmp.length; ++i) {
            nums[left + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 7, 9, 5, 4, 3};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
