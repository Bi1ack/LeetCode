package Perday;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author zr
 * @date 2021.10.25
 */
public class Searcha2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (binarySearch(matrix[i], 0, n - 1, target)) return true;
        }
        return false;
    }

    public static boolean binarySearch (int[] arr, int left, int right, int target) {
        int mid = (left + right) / 2;
        while (left <= right) {
            if (arr[mid] < target) {
                left = mid + 1;
            } else if(arr[mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
            mid = (left + right) / 2;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = 1, w = 2;
        int[][] arr = new int[l][w];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        boolean res;
//        res = binarySearch(arr, 0, arr.length - 1, 3);
        res = searchMatrix(arr, 3);
        System.out.println(res);
    }
}
