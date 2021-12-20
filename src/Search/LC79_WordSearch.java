package Search;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2021-12-20 19:57
 **/
public class LC79_WordSearch {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    // dfs搜索是否存在word
                    visited[i][j] = true;
                    dfs(word, board, i, j, 0, visited);
                    if(flag) {
                        return true;
                    } else {
                        visited[i][j] = false;
                        continue;
                    }
                }
            }
        }
        return false;
    }

    // dfs回溯搜索是否存在word
    static int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean flag = false;

    public static void dfs(String word, char[][] board, int row, int col, int k, boolean[][] visited) {
        if (k == word.length() - 1) {
            flag = true;
            return;
        }
        k++;
        for (int[] d : direction) {
            int x = row + d[0];
            int y = col + d[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if (!visited[x][y] && word.charAt(k) == board[x][y]) {
                    visited[x][y] = true;
                    dfs(word, board, x, y, k, visited);
                }
            }
        }
        visited[row][col] = false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'A'}, {'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}};
        String word = "ABCB";
        System.out.print(exist(board, word));
    }

}
