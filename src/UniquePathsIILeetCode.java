/**
 * Created by snrao on 12/29/16.
 *
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 */
public class UniquePathsIILeetCode {


    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0 || obstacleGrid[0].length==0) return 0;
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        int fill=1;
        for(int i=0;i<dp[0].length;i++){
            if(obstacleGrid[0][i]==1) fill=0;
            dp[0][i]=fill;
        }
        fill=1;
        for(int i=0;i<dp.length;i++){
            if(obstacleGrid[i][0]==1) fill=0;
            dp[i][0]=fill;
        }

        for (int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }


    public static void main(String args[]){
        int[][] grid=new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(grid));
    }
}
