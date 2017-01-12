/**
 * Created by S N Rao on 1/12/2017.
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 *
 */
public class MaximalSquareLeetCode {

    public static int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int max=0,m=matrix.length,n=matrix[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++) if(matrix[i][0]=='1') {dp[i][0]=1; max=1;}
        for(int i=0;i<n;i++) if(matrix[0][i]=='1') {dp[0][i]=1; max=1;}
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }

    public static void main(String args[]){
        System.out.print(maximalSquare(new char[][]{{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}}));
    }
}
