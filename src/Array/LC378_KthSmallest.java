package Array;

/**
 * @program: LeetCode
 * @description: 有序矩阵的第k小元素
 * @author: zr
 * @date: 2021-11-20 15:45
 **/
public class LC378_KthSmallest {

    // Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
    // Output: 13
    public int kthSmallest(int[][] matrix, int k) {
        // TODO: 2021/11/20
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        int mid = left + (right - left) >> 1;
//        while (matrix[n - 1][0])
        return matrix[0][0];
    }

    public boolean check(int[][] matrix) {
        return false;
    }

}
