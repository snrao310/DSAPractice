/**
 * Created by S N Rao on 1/17/2017.
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 */
public class WordSearchLeetCode {

    static int[][] dirn=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public static boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        String send;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    visited[i][j]=true;
                    send=(word.length()==1)?"":word.substring(1);
                    if(backTrackFunction(word.substring(1),board,i,j,visited))
                        return true;
                    visited[i][j]=false;
                }
            }
        }
        return false;
    }

    private static boolean backTrackFunction(String s,char[][] board,int i,int j,boolean[][] visited){
        if(s.length()==0) return true;
        int m=board.length,n=board[0].length;
        String send;
        for(int d[]: dirn){
            int ni=i+d[0],nj=j+d[1];
            if(ni>=0 && nj>=0 && ni<m && nj<n && !visited[ni][nj] && board[ni][nj]==s.charAt(0)) {
                visited[ni][nj] = true;
                send=(s.length()==1)?"":s.substring(1);
                if (backTrackFunction(send, board, ni, nj, visited))
                    return true;
                visited[ni][nj]=false;
            }
        }
        return false;
    }

    public static void main(String args[]){
        char[][] input=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(input,"ABCCED"));
        System.out.println(exist(input,"SEE"));
        System.out.println(exist(input,"ABCB"));

    }
}
