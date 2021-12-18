package Perday;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2021-12-18 10:03
 **/
public class LC419_Battleships {
    public int countBattleships(char[][] board) {
        // 一艘战舰有同样的列或者行
        // 一次扫描，如果一艘战舰的左侧和上方没有战舰，那么这一定是一艘新的战舰
        int row = board.length;
        int col = board[0].length;
        int ans = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == 'X'){
                    if (i > 0 && board[i - 1][j] == 'X') continue;
                    if (j > 0 && board[i][j - 1] == 'X') continue;
                    ans++;
                }
            }
        }
        return ans;
    }

}
