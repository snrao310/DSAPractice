import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by S N Rao on 8/24/2017.
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
public class SurroundedRegionsLeetCode2 {

    public static void solve(char[][] board) {
        if(board.length==0) return;
        int n=board.length, m=board[0].length;
        for(int i=0;i<n;i++){
            if(board[i][0]== 'O')
                BFS(board,i,0);
            if(board[i][m-1]=='O')
                BFS(board,i,m-1);
        }
        for(int i=0;i<m;i++){
            if(board[0][i]== 'O')
                BFS(board,0,i);
            if(board[n-1][i]=='O')
                BFS(board,n-1,i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='V')
                    board[i][j]='O';
                else
                    board[i][j]='X';
            }
        }
    }

    private static int[][] dirns={{0,1},{1,0},{0,-1},{-1,0}};

    private static void BFS(char[][] board, int i,int j){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{i,j});
        board[i][j]='V';
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int[] d: dirns){
                int inew=cur[0]+d[0];
                int jnew=cur[1]+d[1];
                if(inew<0 || jnew<0 || inew>=board.length ||jnew>=board[0].length || board[inew][jnew]=='X' || board[inew][jnew]=='V')
                    continue;
                board[inew][jnew]='V';
                queue.offer(new int[]{inew,jnew});
            }
        }
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
