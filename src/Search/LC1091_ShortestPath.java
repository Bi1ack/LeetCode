package Search;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 二元矩阵中从左上到右下的最短路径
 * @author: zr
 * @date: 2021-12-16 09:35
 **/
public class LC1091_ShortestPath {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        // BFS
        // https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/solution/bfszui-duan-lu-jing-wen-ti-bfsdfsde-si-k-ngc5/
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length;
        int row, col;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int pathLength = 0;
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        while (!queue.isEmpty()) {
            pathLength++;
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                row = cur[0];
                col = cur[1];
                if (row == n - 1 && col == n - 1) return pathLength;
                for (int[] d : direction) {
                    int tr = row + d[0];
                    int tc = col + d[1];
                    if (tr >= n || tr < 0 || tc >= n || tc < 0) continue;
                    if (grid[tr][tc] == 0){
                        queue.offer(new int[]{tr, tc});
                        grid[tr][tc] = 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0}, {1,0,0}, {1,0,0}};
        int res = shortestPathBinaryMatrix(grid);
        System.out.print(res);
    }
}
