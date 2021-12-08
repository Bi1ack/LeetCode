package Array;

/**
 * @program: LeetCode
 * @description: ···
 * @author: zr
 * @date: 2021-11-20 11:16
 **/
public class LC566_ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m =mat.length, n = mat[0].length;
        if (r * c != m * n) return mat;
        int[][] res = new int[r][c];
//        int[] arr = new int[m*n];
        // 二维数组的一维表示
        for (int x = 0; x < m * n; ++x) {
            res[x / c][x % c] = mat[x / n][x % n];
        }
//        int k = 0;
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j){
//                arr[k++] = mat[i][j];
//            }
//        }
//        k = 0;
//        for (int i = 0; i < r; ++i) {
//            for (int j = 0; j < c; ++j){
//                res[i][j] = arr[k++];
//            }
//        }
        return res;
    }

}
