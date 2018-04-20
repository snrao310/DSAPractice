package Done;

import java.util.Arrays;

/**
 * Created by S N Rao on 4/5/2017.
 *
 * Let's play the minesweeper game (Wikipedia, online game)!
 *
 * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an
 * unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and
 * all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
 * finally 'X' represents a revealed mine.
 *
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the
 * board after revealing this position according to the following rules:
 *
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its
 * adjacent unrevealed squares should be revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8')
 * representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 *
 * Example 1:
 * Input:
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 * Click : [3,0]
 * Output:
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 *
 * Example 2:
 * Input:
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * Click : [1,2]
 * Output:
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'X', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 *
 * Note:
 * The range of the input matrix's height and width is [1,50].
 * The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least
 * one clickable square.
 * The input board won't be a stage when game is over (some mines have been revealed).
 * For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all
 * the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
 *
 */
public class MinesweeperLeetCode {

    //If the click is a mine just change 'M' to 'X'. Else do dfs/bfs to see how to find all blank cells (no mine and no
    //neighboring mines also) it can reach and mark them 'B'. Mark the first cell with neighboring mines found with the
    //number of neighboring mines.
    static int[][] dirns={{0,1},{0,-1},{1,0},{1,-1},{1,1},{-1,0},{-1,-1},{-1,1}};

    public static char[][] updateBoard(char[][] board, int[] click) {
        int m=board.length, n=board[0].length, i=click[0], j=click[1];
        char[][] newBoard=Arrays.copyOf(board,m);
        if(board[i][j]=='M')
            newBoard[i][j]='X';
        else
            dfs(board,newBoard,i,j,new boolean[m][n]);
        return newBoard;
    }

    private static void dfs(char[][] board,char[][] newBoard, int i, int j, boolean[][] visited){
        if(visited[i][j])
            return;

        visited[i][j]=true;
        int mineCount=0;
        for(int[] d: dirns){
            int inew=i+d[0], jnew=j+d[1];
            if(inew<0 || inew>=board.length || jnew<0 || jnew>=board[0].length) continue;
            if(board[inew][jnew]=='M')
                mineCount++;
        }

        if(mineCount!=0) newBoard[i][j]=(char)(mineCount+'0');
        else {
            newBoard[i][j]='B';
            for(int[] d: dirns){
                int inew=i+d[0], jnew=j+d[1];
                if(inew<0 || inew>=board.length || jnew<0 || jnew>=board[0].length) continue;
                    dfs(board,newBoard,inew,jnew,visited);
            }
        }
    }

    public static void main(String args[]){
        char[][] board={{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'}};

        board=updateBoard(board,new int[]{3,0});
        for(char[] cArr: board)
            System.out.println(Arrays.toString(cArr));
        System.out.println();

        board=updateBoard(board,new int[]{1,2});
        for(char[] cArr: board)
            System.out.println(Arrays.toString(cArr));
    }
}
