package CodeInterview;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-27 10:26
 **/
public class Code12_exist {

    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] isVisited;

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        isVisited = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, String s, int i, int j, int index) {
        if (s.charAt(index) != board[i][j]) {
            return false;
        }
        if (index == s.length() - 1) {
            return true;
        }
        isVisited[i][j] = true;
        for (int[] d : direction) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || isVisited[x][y]) {
                continue;
            }
           if(dfs(board, s, x, y, index + 1))
               return true;
        }
        isVisited[i][j] = false;

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String s = "ABCCED";
        System.out.println(exist(board, s));
    }

}
