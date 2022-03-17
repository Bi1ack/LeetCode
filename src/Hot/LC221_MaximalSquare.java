package Hot;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-17 10:57
 **/
public class LC221_MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                dp[i][j] = matrix[i][j] == '1'? 1 : 0;
                ans = Math.max(dp[i][j], ans);
            }
        }
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (dp[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j -1])) + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        char[][] m =
                {{'1','1','1','0','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(m));
    }


}
