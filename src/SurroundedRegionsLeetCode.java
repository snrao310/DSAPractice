/**
 * Created by S N Rao on 1/25/2017.
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 */
public class SurroundedRegionsLeetCode {

    static int[][] dirn={{0,1},{0,-1},{1,0},{1,-1},{1,1},{-1,0},{-1,-1},{-1,1}};

    public static void solve(char[][] board) {
        if(board.length==0) return;
        int height=board.length, width=board[0].length;
        for(int i=0;i<width;i++){
            if(board[0][i]=='O')
                DFS(0,i,board);
            if(board[height-1][i]=='O')
                DFS(height-1,i,board);
        }
        for(int i=0;i<height;i++){
            if(board[i][0]=='O')
                DFS(i,0,board);
            if(board[i][width-1]=='O')
                DFS(i,width-1,board);
        }
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='V') board[i][j]='O';
            }
        }
    }

    private static void DFS(int i,int j,char[][] board){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='X' || board[i][j]=='V') return;
        board[i][j]='V';
        for(int[] d: dirn)
            DFS(i+d[0],j+d[1],board);
    }

    public static void main(String args[]){
        char[][] board=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        for (char[] c:board){
            for(char ch: c)
                System.out.print(ch+" ");
            System.out.println();
        }
    }
}
