import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by snrao on 12/27/16.
 * <p>
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the
 * "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and
 * bottom edges.
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal
 * or lower.
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 */
public class PacificAtlanticWaterFlowLeetCode {

    public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if(matrix.length==0) return result;
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
//            DFS(matrix,pacific,Integer.MIN_VALUE,i,0);
//            DFS(matrix,atlantic,Integer.MIN_VALUE,i,matrix[i].length-1);
            BFS(matrix,pacific,i,0);
            BFS(matrix,atlantic,i,matrix[i].length-1);
        }
        for(int i=0;i<matrix[0].length;i++){
//            DFS(matrix,pacific,Integer.MIN_VALUE,0,i);
//            DFS(matrix,atlantic,Integer.MIN_VALUE,matrix.length-1,i);
            BFS(matrix,pacific,0,i);
            BFS(matrix,atlantic,matrix.length-1,i);
        }
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[i].length;j++)
                if(pacific[i][j]&&atlantic[i][j])
                    result.add(new int[]{i,j});
        return result;
    }

    //This is the way we do DFS graph search in matrices.
    private static void DFS(int[][] matrix, boolean[][] visited, int height, int i, int j ) {
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || visited[i][j] || height>matrix[i][j])
            return;

        visited[i][j]=true;
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] d:dir){
            DFS(matrix,visited,matrix[i][j],i+d[0],j+d[1]);
        }
    }

    //This is how BFS graph search is done for matrices.
    private static void BFS(int[][] matrix, boolean[][] visited,int i,int j){
        Queue<int[]> queue=new LinkedList();
        visited[i][j]=true;
        queue.offer(new int[]{i,j});
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while (!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int[] d:dir){
                i=cur[0]+d[0];
                j=cur[1]+d[1];
                if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || visited[i][j] || matrix[i][j]<matrix[cur[0]][cur[1]])
                    continue;
                visited[i][j]=true;
                queue.offer(new int[]{i,j});
            }
        }
    }

    public static void main(String args[]) {
        int[][] matrix = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<int[]> list = pacificAtlantic(matrix);
        for (int[] a : list) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
