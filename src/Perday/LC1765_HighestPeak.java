package Perday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2022-01-29 19:22
 **/
public class LC1765_HighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int[][] direction = new int[][]{{0,1}, {0, -1}, {1,0}, {-1,0}};
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans[i][j] = isWater[i][j] == 0 ? -1 : 0;
                if (isWater[i][j] == 1) queue.offer(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] coo = queue.poll();
                for (int[] d : direction) {
                    int x = d[0] + coo[0], y = d[1] + coo[1];
                    if (x >=0 && x < m && y >= 0 && y < n && ans[x][y] == -1) {
                        ans[x][y] = ans[coo[0]][coo[1]] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return ans;
    }
}
