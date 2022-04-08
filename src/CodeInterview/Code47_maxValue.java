package CodeInterview;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-08 10:23
 **/
public class Code47_maxValue {

    static int ans = -1;
    static int[][] direction = {{0, 1}, {1, 0}};

    public static int maxValue(int[][] grid) {
        backtrack(grid, 0, 0, grid[0][0]);
        return ans;
    }

    private static void backtrack(int[][] grid, int row, int col, int valSum) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            ans = Math.max(ans, valSum);
            return;
        }
        for (int[] d : direction) {
            int x = row + d[0];
            int y = col + d[1];
            if (x >= grid.length || y >= grid[0].length) {
                continue;
            }
            backtrack(grid, x, y, valSum + grid[x][y]);
        }
    }

    public static int maxValue_(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < n; ++i) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(maxValue_(grid));
    }

}
