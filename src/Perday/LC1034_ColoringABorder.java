package Perday;

/**
 * @program: LeetCode
 * @description: 边界着色
 * @author: zr
 * @date: 2021-12-07 16:56
 **/
public class LC1034_ColoringABorder {
    static int[][] res;
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        // 递归
        // 从中心点开始， 递归的寻找每个点的上下左右点， 判断它···
        int origiColor = grid[row][col];
        res = grid.clone();
        colorChange(grid, row, col, color, origiColor);
        return grid;

    }

    public static void colorChange(int[][] grid, int i, int j, int color, int origiColor) {
        if (i < 0 || j < 0 || grid[i][j] != origiColor) return;
        // 怎么做到不走回头路？
        // TODO: 2021/12/7  
        if (i == 0 || grid[i - 1][j] != origiColor) {
            grid[i][j] = color;
        } else {
            colorChange(grid, i - 1, j, color, origiColor);
        }
        if (i == grid.length - 1 || grid[i + 1][j] != origiColor) {
            grid[i][j] = color;
        } else {
            colorChange(grid, i + 1, j, color, origiColor);
        }
        if (j == 0 || grid[i][j - 1] != origiColor) {
            grid[i][j] = color;
        } else {
            colorChange(grid, i, j - 1, color, origiColor);
        }
        if (j == grid[0].length - 1 || grid[i][j + 1] != origiColor) {
            grid[i][j] = color;
        } else {
            colorChange(grid, i, j + 1, color, origiColor);
        }
    }

    int m, n, c;
    int[][] grid, ans;
    int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int[][] colorBorder_(int[][] _grid, int row, int col, int color) {
        grid = _grid; c = color;
        m = grid.length; n = grid[0].length;
        ans = new int[m][n];
        dfs(row, col);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 0) ans[i][j] = grid[i][j];
            }
        }
        return ans;
    }
    void dfs(int x, int y) {
        int cnt = 0;
        for (int[] di : dirs) {
            int nx = x + di[0], ny = y + di[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (grid[x][y] != grid[nx][ny]) continue;
            else cnt++;
            if (ans[nx][ny] == -1) continue;
            ans[nx][ny] = -1;
            dfs(nx, ny);
        }
        ans[x][y] = cnt == 4 ? grid[x][y] : c;
    }


    public static void main(String[] args) {
        int[][] arr = {{1,1,1}, {1,1,1}, {1,1,1}};
        int[][] res =  colorBorder(arr, 1, 1, 3);
    }

}
