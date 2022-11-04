package CodeInterview.Code;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Code107_updateMatrix {
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        int pathLen = 0;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    continue;
                }
                queue.offer(new int[]{i, j});
                pathLen = 0;
                boolean[][] isVisited = new boolean[m][n];
                isVisited[i][j] = true;
                start:
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    ++pathLen;
                    for (int k = 0; k < size; ++k) {
                        int x = queue.peek()[0];
                        int y = queue.peek()[1];
                        queue.poll();
                        for (int[] d : directions) {
                            int dx = x + d[0];
                            int dy = y + d[1];
                            if ( dx < 0 || dy < 0 || dx >= m || dy >= n || isVisited[dx][dy]) continue;
                            if (mat[dx][dy] == 0) {
                                ans[i][j] = pathLen;
                                queue.clear();
                                break start;
                            }
                            isVisited[dx][dy] = true;
                            queue.offer(new int[]{dx, dy});
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[][] ans = updateMatrix(mat);
        for (int i = 0; i < mat.length; ++i) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
