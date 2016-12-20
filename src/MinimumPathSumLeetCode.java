/**
 * Created by snrao on 12/20/16.
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes
 * the sum of all numbers along its path.
 *
 */
public class MinimumPathSumLeetCode {

    //Bottom up dynamic programming
    public static int minPathSum(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for(int i=1;i<grid.length;i++)
            dp[i][0]=dp[i-1][0]+grid[i][0];
        for(int i=1;i<grid[0].length;i++)
            dp[0][i]=dp[0][i-1]+grid[0][i];

        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[i].length;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String args[]){
        System.out.print(minPathSum(new int[][]{{1,2,3,4,6},{3,4,6,9,2},{1,2,3,9,6}}));
    }
}
