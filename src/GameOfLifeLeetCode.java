/**
 * Created by snrao on 12/20/16.
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * Could you solve it in-place?
 */
public class GameOfLifeLeetCode {

    //The best use of bit manipulation I've come across till now.
    public static void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = 0;

                for (int ii = i - 1; ii <= i + 1; ii++) {
                    for (int jj = j - 1; jj <= j + 1; jj++) {
                        if (ii == i && jj == j) continue;
                        if (ii < 0 || ii > board.length - 1) continue;
                        if (jj < 0 || jj > board[0].length - 1) continue;
                        if ((board[ii][jj] & 1) != 0)
                            count++;
                    }
                }

                if (count == 3 || (count == 2 && board[i][j] == 1))
                    board[i][j] |= 2;
                else
                    board[i][j] &= 1;
            }
        }

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                board[i][j] >>= 1;
    }


    public static void main(String args[]) {
        int[][] mat = new int[][]{{1, 0, 1}, {0, 1, 1}, {0, 0, 0}};
        gameOfLife(mat);
        for (int[] n : mat) {
            for (int i : n)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
