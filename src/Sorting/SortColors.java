package Sorting;

import java.util.Random;

import static Algorithm.Sort.swap;

/**
 * @author zr
 * @date 2021.10.27
 */
public class SortColors {
    /**
     * @param arr : int[]
     */
    public static void sortColors(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int[] k = partition(arr, left, right);
            sort(arr, left, k[0] - 1);
            sort(arr, k[0] + 1, right);
        }
    }

    public static int[] partition(int[] arr, int left, int right) {
        //三路
        int index = left;
        int less = left - 1;
        int more = right;
        while (index < more) {
            if (arr[index] > arr[right]) {
                swap(arr, index, --more);
            } else if (arr[index] < arr[right]) {
                swap(arr, index++, ++less);
            } else {
                index++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1, 2, 0};
        sortColors(arr);
        for (int a : arr) System.out.print(a + " ");
        //添加随机
//        (int)(Math.random() * (r - l + 1));
    }
}
