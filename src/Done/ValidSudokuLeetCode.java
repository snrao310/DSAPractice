package Done;

import java.util.HashSet;

/**
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 *
 */
public class ValidSudokuLeetCode {

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> map = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            map.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!='.' && map.contains(board[i][j]))
                    return false;
                map.add(board[i][j]);
            }
        }

        for (int i = 0; i < 9; i++) {
            map.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i]!='.' && map.contains(board[j][i]))
                    return false;
                map.add(board[j][i]);
            }
        }

        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                map.clear();
                for (int ii = 0; ii < 3; ii++) {
                    for (int jj = 0; jj<3;jj++){
                        if(board[i+ii][j+jj]!='.' && map.contains(board[i+ii][j+jj]))
                            return false;
                        map.add(board[i+ii][j+jj]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(isValidSudoku(new char[][]{{'1','.','.','.','.','.','.','.','.'},
                {'.','2','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}}));
    }
}
