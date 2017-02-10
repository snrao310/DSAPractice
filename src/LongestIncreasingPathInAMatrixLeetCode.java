import java.util.Arrays;

/**
 * Created by S N Rao on 2/10/2017.
 * <p>
 * Given an integer matrix, find the length of the longest increasing path.
 * <p>
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move
 * outside of the boundary (i.e. wrap-around is not allowed).
 * <p>
 * Example 1:
 * <p>
 * nums = [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * <p>
 * Example 2:
 * <p>
 * nums = [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class LongestIncreasingPathInAMatrixLeetCode {

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dp[i][j]==-1)
                    max=Math.max(max,dfs(matrix,dp,i,j,-1));
            }
        }
        return max;
    }

    static int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};

    private static int dfs(int[][] matrix,int[][] dp,int i,int j,int height){
        if(i<0 ||j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j]<=height) return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];

        int max=Integer.MIN_VALUE;
        for(int[] d:dirs){
            int ival=i+d[0];
            int jval=j+d[1];
            max=Math.max(max, 1 + dfs(matrix,dp,ival,jval,matrix[i][j]));
        }
        dp[i][j]=max;
        return max;
    }


    public static void main(String args[]) {
        System.out.println(longestIncreasingPath(new int[][]{{9, 9, 4},{6, 6, 8}, {2, 1, 1}}));
        System.out.println(longestIncreasingPath(new int[][]{{3, 4, 5},{3, 2, 6}, {2, 2, 1}}));
    }
}
