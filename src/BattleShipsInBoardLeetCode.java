/**
 * Created by snrao on 11/5/16.
 * Given an 2D board, count how many different battleships are in it. The battleships are represented with 'X's, empty
 * slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN
 * (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
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
