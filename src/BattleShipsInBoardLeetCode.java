/**
 * Created by snrao on 11/5/16.
 */
public class BattleShipsInBoardLeetCode {

    //Counts number of battleships based on definition
    public static int countBattleships(char[][] board) {

        int bs = 0;
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    if ((j == m - 1 || board[i][j + 1] == '.') && (i == n - 1 || board[i + 1][j] == '.'))
                        bs++;
                }
            }
        }
        return bs;
    }


    public static void main(String[] args) {
        char board[][] = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        System.out.print(countBattleships(board));
    }

}
