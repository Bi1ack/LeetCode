package CodeInterview;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-31 10:25
 **/
public class Code29_spiralOrder {

    static int cnt;
    public static int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] A = {0, 0};
        int[] B = {m - 1, n - 1};
        int[] ans = new int[m * n];
        cnt = 0;
        while (true) {
            if (B[0] < A[0] || B[1] < A[1]) break;
            if (A[0] == B[0] && A[1] == B[1]) {
                ans[cnt] = matrix[A[0]][B[0]];
                break;
            }
            if (A[0] < B[0] && A[1] < B[1]) {
                print(matrix, A, B, ans);
                A[0]++;
                A[1]++;
                B[0]--;
                B[1]--;
            } else if (A[0] < B[0]) {
                for (int i = A[0]; i <= B[0]; ++i) {
                    ans[cnt++] = matrix[i][A[1]];
                }
                break;
            } else {
                for (int i = A[1]; i <= B[1]; ++i) {
                    ans[cnt++] = matrix[A[0]][i];
                }
                break;
            }
        }


        return ans;
    }

    private static void print(int[][] matrix, int[] A, int[] B, int[] ans) {
        for (int i = A[1]; i <= B[1]; ++i) {
            ans[cnt++] = matrix[A[0]][i];
        }
        for (int i = A[0] + 1; i <= B[0]; ++i) {
            ans[cnt++] = matrix[i][B[1]];
        }
        for (int i = B[1] - 1; i >= A[1]; --i) {
            ans[cnt++] = matrix[B[0]][i];
        }
        for (int i = B[0] - 1; i > A[0]; --i) {
            ans[cnt++] = matrix[i][A[1]];
        }
    }

    public int[] spiralOrder_(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }


    public static void main(String[] args) {
        int[][] m = {{1,2}, {5,6}, {9,10}};
        System.out.println(Arrays.toString(spiralOrder(m)));
    }
}
