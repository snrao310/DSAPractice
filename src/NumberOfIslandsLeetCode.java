/**
 * Created by snrao on 12/27/16.
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by
 * water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 *
 */
public class NumberOfIslandsLeetCode {

    public static int numIslands(char[][] grid) {
        if(grid.length==0)
            return 0;
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]) continue;
                else if(grid[i][j]=='1') {
                    count++;
                    DFS(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    //This is the way we to graph search in matrices. Same as Pacific Atlantic Water Flow question.
    public static void DFS(char[][] grid, boolean[][] visited, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] || grid[i][j]=='0')
            return;

        visited[i][j]=true;
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] d:dir){
            DFS(grid,visited,i+d[0],j+d[1]);
        }
    }

    public static void main(String args[]){
        char[][] grid=new char[][]{{'1','1','0','0'},{'0','0','1','1'},{'0','1','0','0'}};
        System.out.println(numIslands(grid));
    }
}
