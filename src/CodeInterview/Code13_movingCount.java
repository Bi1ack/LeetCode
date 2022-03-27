package CodeInterview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-27 11:14
 **/
public class Code13_movingCount {

    static int ans = 0;
    public static int movingCount (int m, int n, int k) {
        boolean[][] help = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                help[i][j] = bitSum(i, j) <= k;
            }
        }
        dfs(0, 0, help);

        return ans;
    }

    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void dfs(int i, int j, boolean[][] help) {
        if (help[i][j]) {
            help[i][j] = false;
            ans++;
            for (int[] d : direction) {
                int x = i + d[0];
                int y = j + d[1];
                if (x < 0 || x >= help.length || y < 0 || y >= help[0].length || !help[x][y]) {
                    continue;
                }

                dfs(x, y, help);
            }
        }
    }

    public static int bitSum(int x, int y) {
        int sum = 0;
        while (x != 0 || y != 0) {
            sum += x % 10;
            x = x / 10;
            sum += y % 10;
            y = y / 10;
        }
        return sum;
    }

    //-----------------------------------------------------------//
    public int movingCount_(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean visited[][]) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]
                || (i / 10 + i % 10 + j / 10 + j % 10) > k) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited) + 1;
    }

    //---------------BFS--------------------------

    public int movingCount1(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(movingCount(13, 13, 4));
    }
}
