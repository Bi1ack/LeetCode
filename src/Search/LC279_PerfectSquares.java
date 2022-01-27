package Search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 完全平方数
 * @author: zr
 * @date: 2021-12-16 11:04
 **/
public class LC279_PerfectSquares {

    public static int numSquares(int n) {
        // BFS
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(n);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int m = queue.poll();
                for (int i = 1; i * i <= m; ++i) {
                    int tmp = m - i * i;
                    if (tmp == 0)
                        return level;
                    if (!visited.contains(tmp)) {
                        queue.offer(tmp);
                        visited.add(tmp);
                    }
                }
            }
        }
        return level;
    }
    
    // DP
    //
    public int numSquares_(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }


    public static void main(String[] args) {
        int n = 1247;
        int res = numSquares(n);
        System.out.print(res);
    }
}
