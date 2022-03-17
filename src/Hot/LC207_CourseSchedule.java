package Hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-17 09:57
 **/
public class LC207_CourseSchedule {

    static List<List<Integer>> edges;
    static int[] visited;
    static boolean valid = true;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public static void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }

    // -----------------------------------------------------//
    static List<Integer>[] graphic;
    // 标记每一次 dfs 走过的节点
    static boolean[] isVisited;
    // 标记之前走过的节点， 其中必定不包含环， 避免重复走而超时
    static boolean[] isVisitedGlobal;
    public static boolean canFinish_(int numCourses, int[][] prerequisites) {
        // 建图
        graphic = new List[numCourses];
        isVisited = new boolean[numCourses];
        isVisitedGlobal = new boolean[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            graphic[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            graphic[pre[0]].add(pre[1]);
        }
        // 判断是否有环
        for (int i = 0; i < graphic.length; ++i) {
            if (hasCycle(graphic, i))
                return false;
        }
        return true;

    }

    public static boolean hasCycle(List<Integer>[] graphic, int curNode) {

        if (isVisited[curNode])
            return true;

        if (isVisitedGlobal[curNode])
            return false;

        isVisited[curNode] = true;
        isVisitedGlobal[curNode] = true;

        for (int nextNode : graphic[curNode]) {
            if (hasCycle(graphic, nextNode)) {
                return true;
            }
        }

        isVisited[curNode] = false;

        return false;
    }

    public static void main(String[] args) {
        int[][] pre = {{0, 1}, {0, 2}, {1, 2}, {2, 0}};
        System.out.println(canFinish_(3, pre));
    }
}
