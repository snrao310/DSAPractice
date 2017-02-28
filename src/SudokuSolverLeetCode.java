import java.util.HashSet;

/**
 * Created by S N Rao on 2/27/2017.
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * Empty cells are indicated by the character '.'.
 *
 */
public class SudokuSolverLeetCode {

    public static void solveSudoku(char[][] board) {
        boolean[][] rows=new boolean[9][9];
        boolean[][] cols=new boolean[9][9];
        boolean[][] boxes=new boolean[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.') {
                    int num=Character.getNumericValue(board[i][j]);
                    rows[i][num-1]=true;
                    cols[j][num-1]=true;
                    boxes[(i/3)*3 + (j/3)][num-1]=true;
                }
            }
        }

        backTrackFunction(board, rows, cols, boxes, 0,0);
    }

    private static boolean backTrackFunction(char[][] boards, boolean[][] rows, boolean[][] cols,
                                             boolean[][] boxes, int r, int c){
        if(r>8) return true;

        int newc=c+1, newr=r+1;
        if(c<8) {newr=r; newc=c+1;}
        else if(r<8) {newr=r+1; newc=0;}

        if(boards[r][c]!='.')
            return backTrackFunction(boards, rows, cols, boxes, newr, newc);

        for(int i=1;i<=9;i++){
            if(rows[r][i-1]==false && cols[c][i-1]==false && boxes[(r/3)*3 + (c/3)][i-1]==false) {
                boards[r][c] = (char) (i + '0');
                rows[r][i-1]=true; cols[c][i-1]=true; boxes[(r/3)*3 + (c/3)][i-1]=true;
                if(backTrackFunction(boards,rows,cols,boxes,newr,newc) == true)
                    return true;
                rows[r][i-1]=false; cols[c][i-1]=false; boxes[(r/3)*3 + (c/3)][i-1]=false;
                boards[r][c] = '.';
            }
        }
        return false;
    }

    public static void main(String args[]){
        char[][] board={{'.','.','9','7','4','8','.','.','.',},
                {'7','.','.','.','.','.','.','.','.',},
                {'.','2','.','1','.','9','.','.','.',},
                {'.','.','7','.','.','.','2','4','.',},
                {'.','6','4','.','1','.','5','9','.',},
                {'.','9','8','.','.','.','3','.','.',},
                {'.','.','.','8','.','3','.','2','.',},
                {'.','.','.','.','.','.','.','.','6',},
                {'.','.','.','2','7','5','9','.','.',}};
        solveSudoku(board);
        for(char[] ch:board){
            for(char c:ch)
                System.out.print(c+" ");
            System.out.println();
        }
    }
}
