package Array;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @description: test file
 * @author: zr
 * @date: 2021-11-24 10:30
 **/
public class test {
    // leetcode 766
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 上三角
        for (int i = n - 2; i >= 0; --i) {
            int row = 0, col = i;
            while (row < m - 1 && col < n - 1) {
                if (matrix[row][col] != matrix[row + 1][col + 1]){
                    return false;
                }
                ++row;
                ++col;
            }
        }
        // 下三角
        for (int i = n - 2; i >= 0; --i) {
            int row = i, col = 0;
            while (row < m - 1 && col < n - 1) {
                if (matrix[row][col] != matrix[row + 1][col + 1]){
                    return false;
                }
                ++row;
                ++col;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int m = 6, n = 2;
        Scanner in = new Scanner(System.in);
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                mat[i][j] = in.nextInt();
            }
        }

        isToeplitzMatrix(mat);
    }

}
